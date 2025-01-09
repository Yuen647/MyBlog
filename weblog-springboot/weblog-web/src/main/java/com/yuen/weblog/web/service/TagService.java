package com.yuen.weblog.web.service;

import com.yuen.weblog.common.utils.Response;
import com.yuen.weblog.web.model.vo.tag.FindTagArticlePageListReqVO;
import com.yuen.weblog.web.model.vo.tag.FindTagListReqVO;

public interface TagService {
    /**
     * 获取标签列表
     * @return
     */
    Response findTagList(FindTagListReqVO findTagListReqVO);

    /**
     * 获取标签下文章分页列表
     * @param findTagArticlePageListReqVO
     * @return
     */
    Response findTagPageList(FindTagArticlePageListReqVO findTagArticlePageListReqVO);
}
