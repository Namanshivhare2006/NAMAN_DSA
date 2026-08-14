# Write your MySQL query statement below
select user_id,count(user_id) as prompt_count,
    round(sum(tokens)/count(user_id),2) as avg_tokens
from prompts 
group by user_id
having count(user_id)>=3  and max(tokens)>avg(tokens)
order by avg_tokens desc ,user_id asc