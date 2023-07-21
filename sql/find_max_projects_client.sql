SELECT client.name, COUNT(project.id) AS max_projects
FROM project
JOIN client ON client.id = project.client_id
GROUP BY project.client_id
HAVING COUNT(project.id) IN (
    SELECT COUNT(id)
    FROM project
    GROUP BY client_id
    ORDER BY COUNT(id) DESC
    LIMIT 1
);
