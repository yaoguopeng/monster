package com.island.monster.service.impl;

import com.island.monster.bean.*;
import com.island.monster.bean.IslandPost;
import com.island.monster.common.IslandUtil;
import com.island.monster.common.UploadUtil;
import com.island.monster.mapper.*;
import com.island.monster.service.IslandUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Service
public class IslandUploadServiceImpl implements IslandUploadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandUploadServiceImpl.class);

    @Autowired
    private IslandPaintingMapper islandPaintingMapper;

    @Autowired
    private IslandMusicMapper islandMusicMapper;

    @Autowired
    private IslandMovieMapper islandMovieMapper;

    @Autowired
    private IslandIndexMapper islandIndexMapper;

    @Autowired
    private IslandJokeMapper islandJokeMapper;

    @Autowired
    private IslandMottoMapper islandMottoMapper;

    @Autowired
    private IslandPassageMapper islandPassageMapper;

    @Autowired
    private IslandPoemMapper islandPoemMapper;

    @Autowired
    private IslandBackgroundMapper islandBackgroundMapper;

    @Autowired
    private IslandLandscapeMapper islandLandscapeMapper;

    @Autowired
    private IslandPostMapper islandPostMapper;

    @Autowired
    private UploadUtil uploadUtil;

    @Value("${island.path.painting-path}")
    private String paintingPath;

    @Value("${island.path.background-image-path}")
    private String backgroundImagePath;

    @Value("${island.path.landscape-image-path}")
    private String landscapeImagePath;

    @Value("${island.path.music-image-path}")
    private String musicImagePath;

    @Value("${island.path.movie-image-path}")
    private String movieImagePath;

    @Value("${island.path.post-image-path}")
    private String postImagePath;

    @Value("${island.path.joke-image-path}")
    private String jokeImagePath;

    @Value("${island.path.music-path}")
    private String musicPath;

    @Value("${island.location.painting}")
    private String paintingLocation;

    @Value("${island.location.background-image}")
    private String backgroundImageLocation;

    @Value("${island.location.landscape-image}")
    private String landscapeImageLocation;

    @Value("${island.location.music-image}")
    private String musicImageLocation;

    @Value("${island.location.movie-image}")
    private String movieImageLocation;

    @Value("${island.location.post-image}")
    private String postImageLocation;

    @Value("${island.location.joke-image}")
    private String jokeImageLocation;

    @Value("${island.location.music}")
    private String musicLocation;


    @Override
    public IslandIndex uploadIndex(HttpServletRequest request) {
        IslandIndex islandIndex = new IslandIndex();
        islandIndex.setAuthor(IslandUtil.addPrefix(request.getParameter("author")));
        islandIndex.setContent(request.getParameter("content"));
        islandIndex.setCreatedBy(request.getParameter("createdBy"));
        islandIndex.setCreatedTime(IslandUtil.now());
        LOGGER.info("提取到index分享信息：" + islandIndex + "，showingDateBegin：" + request.getParameter("showingDateBegin")
                + "，showingDateEnd：" + request.getParameter("showingDateEnd"));
        try {
            islandIndex.setShowingDateBegin(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDateBegin")));
            islandIndex.setShowingDateEnd(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDateEnd")));
        } catch (ParseException e) {
            LOGGER.info("添加index时日期格式化异常：");
            e.printStackTrace();
        }
        if (islandIndexMapper.insertSelective(islandIndex) == 1) {
            LOGGER.info("成功添加index：" + islandIndex);
        }
        return islandIndex;
    }

    @Override
    public IslandBackground uploadBackground(HttpServletRequest request) {
        // 获取上传的背景图片
        List<MultipartFile> backgroundFiles = ((MultipartHttpServletRequest) request).getFiles("backgroundImage");
        if (backgroundFiles.isEmpty()) {
            LOGGER.info("背景图片上传页面未添加任何图片");
            return null;
        }
        MultipartFile background = backgroundFiles.get(0);
        String originalName = background.getOriginalFilename();
        if (originalName == null) {
            LOGGER.info("背景图片上传 originalName is null !");
            return null;
        }
        String backgroundSurfix = originalName.substring(originalName.lastIndexOf("."));
        // 将背景图片上传
        String backgroundType = request.getParameter("backgroundType");
        String backgroundId = backgroundType + IslandUtil.uuid();
        String backgroundName = backgroundId + backgroundSurfix;
        if (!uploadUtil.upload(background, backgroundImagePath, backgroundName)) {
            LOGGER.info("上传背景图片失败");
            return null;
        }
        // 上传成功后将背景图片信息入库
        IslandBackground islandBackground = new IslandBackground();
        islandBackground.setUuid(backgroundId);
        islandBackground.setBackgroundImagePath(backgroundImageLocation + backgroundName);
        islandBackground.setCreatedTime(IslandUtil.now());
        islandBackground.setBackgroundType(backgroundType);
        islandBackground.setCreatedBy(request.getParameter("createdBy"));
        LOGGER.info("提取到背景图片分享信息：" + islandBackground + "，showingDateBegin:" + request.getParameter("showingDateBegin")
                + "，showingDateEnd:" + request.getParameter("showingDateEnd"));
        try {
            islandBackground.setShowingDateBegin(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDateBegin")));
            islandBackground.setShowingDateEnd(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDateEnd")));
        } catch (Exception e) {
            LOGGER.info("上传背景图片时，展示日期填写错误。");
        }
        if (islandBackgroundMapper.insertSelective(islandBackground) == 1) {
            LOGGER.info("成功上传背景图片>>background：" + islandBackground);
        }
        return islandBackground;
    }

    @Override
    public IslandLandscape uploadLandscape(HttpServletRequest request) {
        // 获取上传的风景图片
        List<MultipartFile> landscapeFiles = ((MultipartHttpServletRequest) request).getFiles("landscapeImage");
        if (landscapeFiles.isEmpty()) {
            LOGGER.info("风景图片上传页面未添加任何图片");
            return null;
        }
        MultipartFile landscape = landscapeFiles.get(0);
        String originalName = landscape.getOriginalFilename();
        if (originalName == null) {
            LOGGER.info("风景图片上传 originalName is null !");
            return null;
        }
        String landscapeSurfix = originalName.substring(originalName.lastIndexOf("."));
        // 将风景图片上传
        String landscapeId = IslandUtil.uuid();
        String landscapeName = landscapeId + landscapeSurfix;
        if (!uploadUtil.upload(landscape, landscapeImagePath, landscapeName)) {
            LOGGER.info("上传风景图片失败");
            return null;
        }
        // 上传成功后将风景图片信息入库
        IslandLandscape islandLandscape = new IslandLandscape();
        islandLandscape.setUuid(landscapeId);
        islandLandscape.setLandscapeImagePath(landscapeImageLocation + landscapeName);
        islandLandscape.setCreatedTime(IslandUtil.now());
        islandLandscape.setLandscapeInfo(request.getParameter("landscapeInfo"));
        islandLandscape.setCreatedBy(request.getParameter("createdBy"));
        LOGGER.info("提取到风景图片分享信息：" + islandLandscape + "，showingDate:" + request.getParameter("showingDate"));
        try {
            islandLandscape.setShowingDate(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDate")));
        } catch (Exception e) {
            LOGGER.info("上传风景图片时，展示日期填写错误。");
        }
        if (islandLandscapeMapper.insertSelective(islandLandscape) == 1) {
            LOGGER.info("成功上传风景图片>>landscape：" + islandLandscape);
        }
        return islandLandscape;
    }

    @Override
    public IslandJoke uploadJoke(HttpServletRequest request) {
        // 获取上传的段子图片
        List<MultipartFile> jokeImageFiles = ((MultipartHttpServletRequest) request).getFiles("jokeImage");
        IslandJoke islandJoke = new IslandJoke();
        String jokeUuid = IslandUtil.uuid();
        if (!jokeImageFiles.isEmpty()) { //带图
            MultipartFile jokeImage = jokeImageFiles.get(0);
            String originalName = jokeImage.getOriginalFilename();
            if (originalName == null) {
                LOGGER.info("段子图片上传 originalName is null !");
                return null;
            }
            String jokeImageSurfix = originalName.substring(originalName.lastIndexOf("."));
            // 将段子图片上传
            String jokeImageName = jokeUuid + jokeImageSurfix;
            if (uploadUtil.upload(jokeImage, jokeImagePath, jokeImageName)) {
                islandJoke.setImagePath(jokeImageLocation + jokeImageName);
                islandJoke.setContent("");
                LOGGER.info("上传段子图片成功！");
            } else {
                LOGGER.info("上传段子图片失败！");
                return null;
            }
        } else {// 不带图
            islandJoke.setContent(request.getParameter("content"));
            islandJoke.setImagePath(jokeImageLocation + "defaultJokeImage.jpg");
            LOGGER.info("段子图片上传页面未添加任何图片");
        }
        islandJoke.setUuid(jokeUuid);
        islandJoke.setCreatedTime(IslandUtil.now());
        if (islandJokeMapper.insertSelective(islandJoke) == 1) {
            LOGGER.info("成功添加joke：" + islandJoke);
        }
        return islandJoke;
    }

    @Override
    public IslandMotto uploadMotto(HttpServletRequest request) {
        IslandMotto islandMotto = new IslandMotto();
        islandMotto.setCreatedTime(IslandUtil.now());
        islandMotto.setAuthor(IslandUtil.addPrefix(request.getParameter("author")));
        islandMotto.setContent(request.getParameter("content"));
        islandMotto.setCreatedBy(request.getParameter("createdBy"));
        islandMotto.setMottoFrom(IslandUtil.coverByQuotes(request.getParameter("mottoFrom")));
        LOGGER.info("提取到motto分享信息：" + islandMotto + "，showingDate:" + request.getParameter("showingDate"));
        try {
            islandMotto.setShowingDate(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDate")));
        } catch (ParseException e) {
            LOGGER.info("添加motto时日期格式化异常：");
            e.printStackTrace();
        }
        if (islandMottoMapper.insertSelective(islandMotto) == 1) {
            LOGGER.info("成功添加motto：" + islandMotto);
        }
        return islandMotto;
    }

    @Override
    public IslandPassage uploadPassage(HttpServletRequest request) {
        IslandPassage islandPassage = new IslandPassage();
        islandPassage.setCreatedTime(IslandUtil.now());
        islandPassage.setCreatedBy(request.getParameter("createdBy"));
        islandPassage.setPassageAuthor(IslandUtil.addPrefix(request.getParameter("passageAuthor")));
        islandPassage.setPassageContent(request.getParameter("passageContent"));
        islandPassage.setPassageFrom(IslandUtil.coverByQuotes(request.getParameter("passageFrom")));
        islandPassage.setPassageTitle(request.getParameter("passageTitle"));
        LOGGER.info("提取到passage分享信息：" + islandPassage + "，showingDate:" + request.getParameter("showingDate"));
        try {
            islandPassage.setShowingDate(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDate")));
        } catch (ParseException e) {
            LOGGER.info("添加passage时日期格式化异常：");
            e.printStackTrace();
        }
        if (islandPassageMapper.insertSelective(islandPassage) == 1) {
            LOGGER.info("成功添加passage：" + islandPassage);
        }
        return islandPassage;
    }

    @Override
    public IslandPoem uploadPoem(HttpServletRequest request) {
        IslandPoem islandPoem = new IslandPoem();
        islandPoem.setCreatedTime(IslandUtil.now());
        islandPoem.setCreatedBy(request.getParameter("createdBy"));
        islandPoem.setPoemAuthor(IslandUtil.addPrefix(request.getParameter("poemAuthor")));
        islandPoem.setPoemContent(request.getParameter("poemContent"));
        islandPoem.setPoemType(request.getParameter("poemType"));
        islandPoem.setPoemNote(request.getParameter("poemNote"));
        islandPoem.setPoemExplanation(request.getParameter("poemExplanation"));
        islandPoem.setPoemAppreciation(request.getParameter("poemAppreciation"));
        islandPoem.setPoemTitle(request.getParameter("poemTitle"));
        LOGGER.info("提取到poem分享信息：" + islandPoem + "，showingDate:" + request.getParameter("showingDate"));
        try {
            islandPoem.setShowingDate(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDate")));
        } catch (ParseException e) {
            LOGGER.info("添加poem时日期格式化异常：");
            e.printStackTrace();
        }
        if (islandPoemMapper.insertSelective(islandPoem) == 1) {
            LOGGER.info("成功添加poem：" + islandPoem);
        }
        return islandPoem;
    }

    @Override
    public IslandPainting uploadPainting(HttpServletRequest request) {
        // 获取上传的图片
        List<MultipartFile> paintingFiles = ((MultipartHttpServletRequest) request).getFiles("painting");
        if (paintingFiles.isEmpty()) {
            LOGGER.info("图片上传页面未添加任何图片");
            return null;
        }
        MultipartFile painting = paintingFiles.get(0);
        String originalName = painting.getOriginalFilename();
        if (originalName == null) {
            LOGGER.info("图片上传 originalName is null !");
            return null;
        }
        String paintingSurfix = originalName.substring(originalName.lastIndexOf("."));
        // 将图片上传
        String paintingId = IslandUtil.uuid();
        String paintingName = paintingId + paintingSurfix;
        if (!uploadUtil.upload(painting, paintingPath, paintingName)) {
            LOGGER.info("上传图片失败");
            return null;
        }
        // 上传成功后将图片信息入库
        IslandPainting islandPainting = new IslandPainting();
        islandPainting.setPaintingPath(paintingLocation + paintingName);
        islandPainting.setUuid(paintingId);
        islandPainting.setCreatedTime(IslandUtil.now());
        islandPainting.setPaintingAuthor(IslandUtil.addPrefix(request.getParameter("paintingAuthor")));
        islandPainting.setPaintingInfo(request.getParameter("paintingInfo"));
        islandPainting.setCreatedBy(request.getParameter("createdBy"));
        LOGGER.info("提取到图片分享信息：" + islandPainting + "，showingDate:" + request.getParameter("showingDate"));
        try {
            islandPainting.setShowingDate(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDate")));
        } catch (Exception e) {
            LOGGER.info("上传图片时，展示日期填写错误。");
        }
        if (islandPaintingMapper.insertSelective(islandPainting) == 1) {
            LOGGER.info("成功上传图片>>painting：" + islandPainting);
        }
        return islandPainting;
    }

    @Override
    public IslandMusic uploadMusic(HttpServletRequest request) {
        // 获取上传的音乐
        List<MultipartFile> musicFiles = ((MultipartHttpServletRequest) request).getFiles("music");
        List<MultipartFile> musicImages = ((MultipartHttpServletRequest) request).getFiles("musicImage");
        if (musicFiles.isEmpty()) {
            LOGGER.info("音乐上传页面未添加任何音乐");
            return null;
        }
        if (musicImages.isEmpty()) {
            LOGGER.info("音乐上传页面未添加任何图片");
            return null;
        }
        MultipartFile image = musicImages.get(0);
        MultipartFile music = musicFiles.get(0);
        String musicOriginalName = music.getOriginalFilename();
        String imageOriginalName = image.getOriginalFilename();
        if (musicOriginalName == null) {
            LOGGER.info("音乐上传 musicOriginalName is null !");
            return null;
        }
        if (imageOriginalName == null) {
            LOGGER.info("音乐上传 imageOriginalName is null !");
            return null;
        }
        String musicSurfix = musicOriginalName.substring(musicOriginalName.lastIndexOf("."));
        String imageSurfix = imageOriginalName.substring(imageOriginalName.lastIndexOf("."));
        // 将音乐上传 + 音乐配图上传
        String musicId = IslandUtil.uuid();
        String musicName = musicId + musicSurfix;
        String musicImageName = musicId + imageSurfix;
        if (!uploadUtil.upload(music, musicPath, musicName)) {
            LOGGER.info("上传音乐失败");
            return null;
        }
        if (!uploadUtil.upload(image, musicImagePath, musicImageName)) {
            LOGGER.info("上传音乐配图失败");
            uploadUtil.remove(musicPath + musicName);
            return null;
        }
        // 上传成功后将音乐信息入库
        IslandMusic islandMusic = new IslandMusic();
        islandMusic.setMusicPath(musicLocation + musicName);
        islandMusic.setUuid(musicId);
        islandMusic.setCreatedTime(IslandUtil.now());
        islandMusic.setMusicAlbum(request.getParameter("musicAlbum"));
        islandMusic.setMusicName(IslandUtil.coverByQuotes(request.getParameter("musicName")));
        islandMusic.setMusicSinger(IslandUtil.addPrefix(request.getParameter("musicSinger")));
        islandMusic.setMusicImagePath(musicImageLocation + musicImageName);
        islandMusic.setCreatedBy(request.getParameter("createdBy"));
        LOGGER.info("提取到音乐分享信息：" + islandMusic + "，showingDate:" + request.getParameter("showingDate"));
        try {
            islandMusic.setShowingDate(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDate")));
        } catch (Exception e) {
            LOGGER.info("上传音乐时，展示日期填写错误。");
        }
        if (islandMusicMapper.insertSelective(islandMusic) == 1) {
            LOGGER.info("上传音乐成功>>music:" + islandMusic);
        }
        return islandMusic;
    }

    @Override
    public IslandMovie uploadMovie(HttpServletRequest request) {
        // 获取上传的剧照
        List<MultipartFile> movieImageFiles = ((MultipartHttpServletRequest) request).getFiles("movieImage");
        if (movieImageFiles.isEmpty()) {
            LOGGER.info("电影剧照上传页面未添加任何图片");
            return null;
        }
        MultipartFile movieImage = movieImageFiles.get(0);
        if (movieImage == null) {
            LOGGER.info(" 电影剧照上传 movieImage is null !");
            return null;
        }
        String originalName = movieImage.getOriginalFilename();
        if (originalName == null) {
            LOGGER.info(" 电影剧照上传 originalName of movieImage is null !");
            return null;
        }
        String movieImageSurfix = originalName.substring(originalName.lastIndexOf("."));
        // 将剧照上传
        String movieUuid = IslandUtil.uuid();
        String movieImageName = movieUuid + movieImageSurfix;
        if (!uploadUtil.upload(movieImage, movieImagePath, movieImageName)) {
            LOGGER.info("上传电影剧照失败");
            return null;
        }
        // 上传成功后将电影剧照信息入库
        IslandMovie islandMovie = new IslandMovie();
        islandMovie.setMovieImagePath(movieImageLocation + movieImageName);
        islandMovie.setUuid(movieUuid);
        islandMovie.setCreatedTime(IslandUtil.now());
        islandMovie.setMovieName(IslandUtil.addPrefix(IslandUtil.coverByQuotes(request.getParameter("movieName"))));
        islandMovie.setMovieBeautifulLines(request.getParameter("movieBeautifulLines"));
        islandMovie.setCreatedBy(request.getParameter("createdBy"));
        LOGGER.info("提取到电影推荐信息：" + islandMovie + "，showingDate:" + request.getParameter("showingDate"));
        try {
            islandMovie.setShowingDate(IslandUtil.getSimpleDateFormat().parse(request.getParameter("showingDate")));
        } catch (Exception e) {
            LOGGER.info("上传电影剧照时，展示日期填写错误。");
        }
        if (islandMovieMapper.insertSelective(islandMovie) == 1) {
            LOGGER.info("上传电影剧照成功>>movie:" + islandMovie);
        }
        return islandMovie;
    }

    @Override
    public IslandPost uploadPost(HttpServletRequest request) {
        // 获取帖子上传的图片
        List<MultipartFile> postImages = ((MultipartHttpServletRequest) request).getFiles("postImage");
        IslandPost islandPost = new IslandPost();
        String postId = IslandUtil.uuid();
        islandPost.setId(postId);
        if (!postImages.isEmpty()) {
            MultipartFile postImage = postImages.get(0);
            String originalName = postImage.getOriginalFilename();
            if (originalName != null) {
                String postSurfix = originalName.substring(originalName.lastIndexOf("."));
                // 将帖子图片上传
                String postImageName = postId + postSurfix;
                if (!uploadUtil.upload(postImage, postImagePath, postImageName)) {
                    islandPost.setPostImagePath(postImageLocation + postImageName);
                    LOGGER.info("帖子上传图片成功！");
                } else {
                    LOGGER.info("帖子上传图片失败！");
                    return null;
                }
            } else {
                LOGGER.info("帖子图片上传 originalName is null !");
                return null;
            }
        } else {
            LOGGER.info("帖子上传未添加任何图片");
        }
        // 帖子图片上传成功后将帖子信息入库
        islandPost.setCreatedTime(IslandUtil.now());
        islandPost.setPostContent(IslandUtil.addPrefix(request.getParameter("postContent")));
        islandPost.setTopicId(request.getParameter("topicId"));
        islandPost.setCreatedBy(request.getParameter("createdBy"));
        if (islandPostMapper.insertSelective(islandPost) == 1) {
            LOGGER.info("成功上传帖子>>post：" + islandPost);
        }
        return islandPost;
    }
}
