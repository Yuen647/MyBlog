package com.yuen.weblog.admin.model.service;

import com.yuen.weblog.admin.model.model.vo.comment.DeleteCommentReqVO;
import com.yuen.weblog.admin.model.model.vo.comment.ExamineCommentReqVO;
import com.yuen.weblog.admin.model.model.vo.comment.FindCommentPageListReqVO;
import com.yuen.weblog.common.utils.Response;

public interface AdminCommentService {

    /**
     * 查询评论分页数据
     * @param findCommentPageListReqVO
     * @return
     */
    Response findCommentPageList(FindCommentPageListReqVO findCommentPageListReqVO);

    /**
     * 删除评论
     * @param deleteCommentReqVO
     * @return
     */
    Response deleteComment(DeleteCommentReqVO deleteCommentReqVO);

    /**
     * 评论审核
     * @param examineCommentReqVO
     * @return
     */
    Response examine(ExamineCommentReqVO examineCommentReqVO);

}
