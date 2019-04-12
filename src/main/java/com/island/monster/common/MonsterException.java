package com.island.monster.common;

/**
 * 时光小岛自定义异常
 */
public class MonsterException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    public MonsterException() {
        super();
    }

    public MonsterException(String message) {
        super(message);
    }
}
