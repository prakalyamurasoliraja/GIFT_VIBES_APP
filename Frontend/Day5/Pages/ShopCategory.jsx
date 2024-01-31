// ShopCategory.jsx
import React, { useContext } from 'react';
import './CSS/ShopCategory.css'; // Corrected the path
import { ShopContext } from '../Context/ShopContext';
import dropdown_icon from '../Components/Assets/dropdown_icon.png'
import Item from '../Components/Item/Item'

export const ShopCategory = (props) => {
  const { all_product } = useContext(ShopContext);
  return (
    <div className="shop-category">
       <div className="shopcategory-indexSort">
       <p>
       <br/>
           GIFT COLLECTIONS
       </p>
       <div className="shopcategory-sort">
          
       </div>
       </div>

       <div className="shopcategory-products">
          {all_product.map((item,i)=>{
              if(props.category===item.category)
              {
                  return <Item key={i} id={item.id} name={item.name} image={item.image} new_price={item.new_price} old_price={item.old_price} />
              }
              else{
                return null;
              }
          })}
       </div>
       <div className="shopcategory-loadmore">
          Explore More
       </div>
    </div>
  )
};

export default ShopCategory;
