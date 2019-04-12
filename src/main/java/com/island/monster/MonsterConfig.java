package com.island.monster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 自定义静态文件映射
 */
@Configuration
public class MonsterConfig extends WebMvcConfigurerAdapter {

    @Value("${island.path.painting-path}")
    private String paintingPath;

    @Value("${island.location.painting}")
    private String paintingLocation;

    @Value("${island.path.music-image-path}")
    private String musicImagePath;

    @Value("${island.location.music-image}")
    private String musicImageLocation;

    @Value("${island.path.movie-image-path}")
    private String movieImagePath;

    @Value("${island.location.movie-image}")
    private String movieImageLocation;

    @Value("${island.path.music-path}")
    private String musicPath;

    @Value("${island.location.music}")
    private String musicLocation;

    @Value("${island.path.landscape-image-path}")
    private String landscapeImagePath;

    @Value("${island.location.landscape-image}")
    private String landscapeImageLocation;

    @Value("${island.location.background-image}")
    private String backgroundImageLocation;

    @Value("${island.path.background-image-path}")
    private String backgroundImagePath;

    @Value("${island.path.post-image-path}")
    private String postImagePath;

    @Value("${island.location.post-image}")
    private String postImageLocation;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String suffix = "**";
        String prefix = "file:";
        registry.addResourceHandler(paintingLocation + suffix).addResourceLocations(prefix + paintingPath);
        registry.addResourceHandler(movieImageLocation + suffix).addResourceLocations(prefix + movieImagePath);
        registry.addResourceHandler(musicImageLocation + suffix).addResourceLocations(prefix + musicImagePath);
        registry.addResourceHandler(musicLocation + suffix).addResourceLocations(prefix + musicPath);
        registry.addResourceHandler(landscapeImageLocation + suffix).addResourceLocations(prefix + landscapeImagePath);
        registry.addResourceHandler(backgroundImageLocation + suffix).addResourceLocations(prefix + backgroundImagePath);
        registry.addResourceHandler(postImageLocation + suffix).addResourceLocations(prefix + postImagePath);
        super.addResourceHandlers(registry);
    }
}
