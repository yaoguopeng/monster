package com.island.monster.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.island.monster.bean.IslandPost;
import com.island.monster.bean.IslandPostInfo;
import com.island.monster.common.IslandCommon;
import com.island.monster.common.IslandUtil;
import com.island.monster.highConcurrency.IslandActorService;
import com.island.monster.mapper.*;
import com.island.monster.service.IslandPostService;
import com.island.monster.service.IslandVisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class IslandPostServiceImpl implements IslandPostService {

    @Autowired
    private IslandPostMapper islandPostMapper;

    @Autowired
    private IslandPostReplyMapper islandPostReplyMapper;

    @Autowired
    private IslandPostThumbsUpMapper islandPostThumbsUpMapper;

    @Autowired
    private IslandPostInfoMapper islandPostInfoMapper;

    @Autowired
    private IslandActorService islandActorService;

    @Autowired
    private IslandVisitLogService islandVisitLogService;

    @Autowired
    private IslandVisitorMapper islandVisitorMapper;

    @Override
    public IslandPost getOne(String id) {
        // 访量增加
        return postVisited(islandPostMapper.selectByPrimaryKey(id));
    }

    /**
     * 访量增加
     *
     * @param islandPost
     * @return
     */
    private IslandPost postVisited(IslandPost islandPost) {
        if (islandPost != null) {
            islandActorService.postVisited(islandPost);
        }
        return islandPost;
    }

    @Override
    public IslandPost update(IslandPost islandPost) {
        if (getOne(islandPost.getId()) == null) {
            islandPost.setCreatedTime(IslandUtil.now());
            islandPostMapper.insertSelective(islandPost);
        } else {
            islandPost.setUpdatedTime(IslandUtil.now());
            islandPostMapper.updateByPrimaryKeySelective(islandPost);
        }
        return islandPost;
    }

    @Override
    public IslandPost setDeleted(String id) {
        islandPostMapper.setDeleted(id);
        return getOne(id);
    }

    @Transactional
    @Override
    public IslandPost remove(String id) {
        IslandPost target = getOne(id);
        // 级联删除其下的回复以及点赞信息
        islandPostMapper.remove(id);
        islandPostReplyMapper.removeByPostId(id);
        islandPostThumbsUpMapper.removeByPostId(id);
        islandPostInfoMapper.delete(id);
        return target;
    }

    @Override
    public List<IslandPost> getList(IslandPost islandPost, String currentUnionId) {
        if (currentUnionId != null) {
            // 记录来访信息
            if (islandPostMapper.selectByPrimaryKey(islandPost.getTopicId()) != null) {
                // 访客访问主题帖子
                islandVisitLogService.addOne(currentUnionId, islandPost.getTopicId(), IslandCommon.VisitObjectType.TOPIC);
            }
            if (islandVisitorMapper.selectByUnionId(islandPost.getCreatedBy()) != null) {
                // 访客访问其他访客帖子信息
                islandVisitLogService.addOne(currentUnionId, islandPost.getCreatedBy(), IslandCommon.VisitObjectType.VISITOR);
            }
        }
        return postsVisitTimesIncrease(islandPostMapper.getByConditions(islandPost));
    }

    @Override
    public PageInfo<IslandPost> getPage(IslandPost islandPost, String currentUnionId, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                getList(islandPost, currentUnionId);
            }
        });
        return page;
    }

    @Override
    public List<IslandPost> onesStarsPosts(String unionId) {
        return postsVisitTimesIncrease(islandPostMapper.onesStarsPosts(unionId));
    }

    @Override
    public PageInfo<IslandPost> onesStarsPosts(String unionId, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                onesStarsPosts(unionId);
            }
        });
        return page;
    }

    @Override
    public List<IslandPost> onesFavoriteTopicPosts(String unionId) {
        return postsVisitTimesIncrease(islandPostMapper.onesFavoriteTopicPosts(unionId));
    }

    @Override
    public PageInfo<IslandPost> onesFavoriteTopicPosts(String unionId, Integer pageNum, Integer pageSize) {
        PageInfo page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                postsVisitTimesIncrease(onesFavoriteTopicPosts(unionId));
            }
        });
        return page;
    }


    private List<IslandPost> postsVisitTimesIncrease(List<IslandPost> islandPosts) {
        if (!islandPosts.isEmpty()) {
            ExecutorService pool = Executors.newFixedThreadPool(islandPosts.size());
            CountDownLatch latch = new CountDownLatch(islandPosts.size());
            for (IslandPost islandPost : islandPosts) {
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        postVisited(islandPost);
                        latch.countDown();
                    }
                });
            }
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.shutdown();
        }
        return islandPosts;
    }

    private void postVisitedTimesIncrease(String postId) {
        IslandPostInfo target = islandPostInfoMapper.getByPostId(postId);
        if (target == null) {
            target = new IslandPostInfo();
            target.setPostId(postId);
            target.setPostVisitTimes(0);
            islandPostInfoMapper.insertSelective(target);
        } else {
            target.setPostVisitTimes(target.getPostVisitTimes() + 1);
            islandPostInfoMapper.updateSelective(target);
        }
    }

    @Override
    public IslandPost postVisitedTimesIncrease(IslandPost islandPost) {
        postVisitedTimesIncrease(islandPost.getId());
        return islandPost;
    }
}
