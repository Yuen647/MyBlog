package com.yuen.weblog.web.service;

import com.yuen.weblog.common.utils.Response;
import com.yuen.weblog.web.model.vo.comment.FindCommentListReqVO;
import com.yuen.weblog.web.model.vo.comment.FindQQUserInfoReqVO;
import com.yuen.weblog.web.model.vo.comment.PublishCommentReqVO;

public interface CommentService {

    /**
     * 根据 QQ 号获取用户信息
     * @param findQQUserInfoReqVO
     * @return
     */
    Response findQQUserInfo(FindQQUserInfoReqVO findQQUserInfoReqVO);

    /**
     * 发布评论
     * @param publishCommentReqVO
     * @return
     */
    Response publishComment(PublishCommentReqVO publishCommentReqVO);

    /**
     * 查询页面所有评论
     * @param findCommentListReqVO
     * @return
     */
    Response findCommentList(FindCommentListReqVO findCommentListReqVO);
}
