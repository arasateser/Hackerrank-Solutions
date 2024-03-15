SELECT w.id, wp.age, w.coins_needed, w.power 
FROM Wands w
JOIN Wands_Property wp on w.code = wp.code
WHERE wp.is_evil = 0 and w.coins_needed = (
    SELECT MIN(coins_needed) 
    FROM Wands w1 join Wands_Property wp1 on (w1.code = wp1.code) 
    WHERE w1.power = w.power and wp1.age = wp.age) 
ORDER BY w.power desc, wp.age desc

/*FIRST WHERE CLAUSE:
The condition wp.is_evil = 0 filters the rows where the wand is not marked as evil.
The condition w.coins_needed = (SELECT MIN(coins_needed) ...) filters the rows where the coins needed 
to purchase the wand (w.coins_needed) are equal to the minimum coins needed among wands with the same power and age.

The subquery (SELECT MIN(coins_needed) ...) calculates the minimum coins needed among wands with the same power and 
age. It correlates the subquery with the outer query by matching w1.power = w.power and wp1.age = wp.age.*/
