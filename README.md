# monster
来趣星小程序后台代码

#将项目上传到git
创建git仓库后

①git clone https://github.com/yaoguopeng/monster.git
②git init
③git pull
④git add .
⑤git commit -m "XXXXXXXX"
⑥git remote add origin https://github.com/yaoguopeng/monster.git
⑦git push -u origin master

.git文件夹中的config文件中的内容如下：
[core]
	repositoryformatversion = 0
	filemode = false
	bare = false
	logallrefupdates = true
	symlinks = false
	ignorecase = true
[remote "origin"]
	url = https://github.com/yaoguopeng/monster.git
	fetch = +refs/heads/*:refs/remotes/origin/*
[branch "master"]
	remote = origin
	merge = refs/heads/master
  
  #本地新建分支dev,并提交到远程仓库
  ①本地新建分支：git checkout -b dev
  ②建立本地到上游（远端）仓的链接 --这样代码才能提交上去：git branch --set-upstream-to=origin/dev 
  ③取消对master的跟踪：git branch --unset-upstream master
  ④提交该分支到远程仓库：git push origin dev
