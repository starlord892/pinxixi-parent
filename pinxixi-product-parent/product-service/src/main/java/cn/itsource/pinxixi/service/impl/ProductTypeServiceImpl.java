package cn.itsource.pinxixi.service.impl;

import cn.itsource.pinxixi.domain.ProductType;
import cn.itsource.pinxixi.mapper.ProductTypeMapper;
import cn.itsource.pinxixi.service.IProductTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author starlord892
 * @since 2019-05-16
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    /**
     * 加载类型树
     * （1）递归   看有没有children，有则继续查
     * （2）循环，一次性查询所有的类型，循环添加到children中
     * @return
     */
    @Override
    public List<ProductType> loadTreeData() {
        //查询一级
        return loadDataTree(0L); //递归
        //return loadDataTree(); //循环
    }

    /**
     * 递归：
     * （1）自己调用自己
     * （2）要有出口
     *
     * 查自己的子
     *
     * @return
     */
    private List<ProductType> loadDataTree(Long pid){
        //根据父id查询子类型
        List<ProductType> children = baseMapper.selectList(new QueryWrapper<ProductType>().eq("pid", pid));
        //递归的出口
        if(children==null||children.size()==0){
            return null;
        }
        for (ProductType productType : children) {
            //对子进行循环，调用自己继续查询子的子类型
            List<ProductType> c = loadDataTree(productType.getId());
            //将所有的孙子类型放入到子的children属性中
            productType.setChildren(c);
        }
        return children;
    }


    /**
     * 循环
     * @return
     */
    private List<ProductType> loadDataTree(){

        //查询所有
        List<ProductType> productTypes = baseMapper.selectList(null);
        //放到Map中--大大的降低循环次数
        Map<Long,ProductType> map = new HashMap<>();
        for (ProductType productType : productTypes) {
            map.put(productType.getId(),productType);
        }

        //放所有的一级类型
        List<ProductType> list = new ArrayList<>();
        //子找父
        for (ProductType productType : productTypes) {
            //如果pid为0则自己就是父
            if(productType.getPid()==0){
                list.add(productType);
            }else{
                map.get(productType.getPid()).getChildren().add(productType);
            }
        }
        return list;

    }

}
