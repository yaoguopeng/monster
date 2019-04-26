package com.island.monster.service;

import com.island.monster.bean.*;
import com.island.monster.bean.IslandPost;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface IslandUploadService {

    IslandIndex uploadIndex(HttpServletRequest request);

    IslandBackground uploadBackground(HttpServletRequest request);

    IslandLandscape uploadLandscape(HttpServletRequest request);

    IslandJoke uploadJoke(HttpServletRequest request);

    IslandMotto uploadMotto(HttpServletRequest request);

    IslandPassage uploadPassage(HttpServletRequest request);

    IslandPoem uploadPoem(HttpServletRequest request);

    IslandPainting uploadPainting(HttpServletRequest request);

    IslandMusic uploadMusic(HttpServletRequest request);

    IslandMovie uploadMovie(HttpServletRequest request);

    IslandPost uploadPost(HttpServletRequest request, MultipartFile[] postImages);

    IslandPost editPost(HttpServletRequest request, MultipartFile[] postImages);
}
