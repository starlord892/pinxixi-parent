package cn.itsource.pinxixi.service;

import cn.itsource.pinxixi.domain.Brand;
import cn.itsource.pinxixi.query.BrandQuery;
import cn.itsource.pinxixi.util.PageList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author starlord892
 * @since 2019-05-16
 */
public interface IBrandService extends IService<Brand> {
    PageList<Brand> getByQuery(BrandQuery query);

}
