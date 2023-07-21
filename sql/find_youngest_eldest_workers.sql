SELECT 'YOUNGEST' AS type, name, birthday
FROM worker
WHERE DATEDIFF('DAY',birthday, CURRENT_DATE) IN (
    SELECT DATEDIFF('DAY',birthday, CURRENT_DATE) AS age
    FROM worker
    ORDER BY DATEDIFF('DAY', birthday, CURRENT_DATE) 
    LIMIT 1
)
UNION

SELECT  'OLDEST' AS type, name, birthday
FROM worker
WHERE DATEDIFF('DAY',birthday, CURRENT_DATE) IN (
    SELECT DATEDIFF('DAY',birthday, CURRENT_DATE) AS age
    FROM worker
    ORDER BY DATEDIFF('DAY', birthday, CURRENT_DATE) DESC
    LIMIT 1
);