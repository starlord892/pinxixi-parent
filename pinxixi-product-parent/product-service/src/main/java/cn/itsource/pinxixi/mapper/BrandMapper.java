package cn.itsource.pinxixi.mapper;

import cn.itsource.pinxixi.domain.Brand;
import cn.itsource.pinxixi.query.BrandQuery;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author starlord892
 * @since 2019-05-16
 */
public interface BrandMapper extends BaseMapper<Brand> {

    IPage<Brand> selectByQuery(Page<Brand> page, @Param("query") BrandQuery query);

    IPage<Brand> selectByWrapper(Page<Brand> page,@Param(Constants.WRAPPER) Wrapper wrapper);

}
