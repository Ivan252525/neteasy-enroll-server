package com.neteasy.server.modules.index.service.impl;

import com.neteasy.server.modules.index.entity.IndexActivityEntity;
import com.neteasy.server.modules.index.dao.IndexActivityMapper;
import com.neteasy.server.modules.index.service.IndexActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页活动表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-09
 */
@Service
public class IndexActivityServiceImpl extends ServiceImpl<IndexActivityMapper, IndexActivityEntity> implements IndexActivityService {

}
