select name from customers csm where csm.id not in (select csm.id
from orders ord  inner join customers csm on csm.id = ord.customer_id) 