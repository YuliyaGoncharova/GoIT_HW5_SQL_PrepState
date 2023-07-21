SELECT 'ID of project with max duration:' , id AS name, DATEDIFF('MONTH', start_date,  finish_date) AS month_count
    FROM project
    GROUP BY id
    HAVING DATEDIFF('MONTH', start_date,  finish_date) IN 
    (
        SELECT DATEDIFF('MONTH', start_date,  finish_date)
        FROM project
        GROUP BY id
        ORDER BY DATEDIFF('MONTH', finish_date, start_date) 
        LIMIT 1
    );