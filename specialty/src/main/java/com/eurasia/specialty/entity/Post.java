package com.eurasia.specialty.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 帖子
 * @author Aaron
 * @date 2020/5/17 - 18:42
 **/
@Data
@Entity
@Table(name = "sp_post")
public class Post implements Serializable,  Comparable<Post> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    @Column(name = "images_url")
    private String imagesUrl;
    private String createTime;
    private Integer userId;
    private Integer classifyId;
    private Integer views;
    /**
     * 点赞数量
     */
    @Column(name = "number")
    private Integer number;
    /**
     * 留言的数量
     */
    @Transient
    private Integer commentNum;
    /**
     * 判断是否点赞
     */
    @Transient
    private String status;
    @Transient
    private User user;
    @Transient
    private List<Comment> commentList;

    public int compareTo(Post o) {
        if (getCreateTime().compareTo(o.getCreateTime()) > 0) {
            return -1;
        } else if (getCreateTime().compareTo(o.getCreateTime()) == 0) {
            return 0;
        }
        return 1;
    }
}
