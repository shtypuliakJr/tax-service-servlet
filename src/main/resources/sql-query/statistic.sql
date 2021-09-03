SELECT COUNT(*)                                AS count,
       SUM(IF(r.status = 'PROCESSING', 1, 0))  AS processing_count,
       SUM(IF(r.status = 'APPROVED', 1, 0))    AS approved_count,
       SUM(IF(r.status = 'DISAPPROVED', 1, 0)) AS disapproved_count
FROM report as r;

SELECT year, COUNT(*) as count FROM report AS r group by r.year order by year;

SELECT SUM(IF(u.user_role = 'USER', 1, 0))                        AS user_count,
       SUM(IF(u.user_role = 'INSPECTOR', 1, 0)) AS inspector_count
FROM user as u;

