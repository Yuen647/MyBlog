package com.yuen.weblog.admin.model.service;

import com.yuen.weblog.admin.model.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import com.yuen.weblog.common.utils.Response;

public interface AdminBlogSettingsService {
    /**
     * 更新博客设置信息
     * @param updateBlogSettingsReqVO
     * @return
     */
    Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO);

    /**
     * 获取博客设置详情
     * @return
     */
    Response findDetail();
}
