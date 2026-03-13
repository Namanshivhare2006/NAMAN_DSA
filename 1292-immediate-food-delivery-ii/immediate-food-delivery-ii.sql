SELECT Round(
    sum(
        case 
           when order_date=customer_pref_delivery_date then 1
           else 0
        end 
    )/count(*)*100,2) as immediate_percentage
 from Delivery
where ( customer_id , order_date ) in 
(Select customer_id, min(Order_date) from Delivery group by customer_id )