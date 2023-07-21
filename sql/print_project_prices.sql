SELECT project_id AS name, SUM(worker.salary*DATEDIFF('MONTH', project.start_date,  project.finish_date)) AS total_project_price
FROM project_worker
JOIN worker ON worker.id = project_worker.worker_id
JOIN project ON project.id = project_worker.project_id
GROUP BY project_id
ORDER BY total_project_price DESC;