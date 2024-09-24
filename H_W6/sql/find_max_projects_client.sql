WITH project_counts AS (
    SELECT
        c.NAME AS client_name,
        COUNT(p.ID) AS project_count
    FROM
        client c
            LEFT JOIN
        project p ON c.ID = p.CLIENT_ID
    GROUP BY
        c.NAME
),
     max_project_count AS (
         SELECT
             MAX(project_count) AS max_count
         FROM
             project_counts
     )
SELECT
    client_name AS NAME,
    project_count
FROM
    project_counts
WHERE
    project_count = (SELECT max_count FROM max_project_count);

