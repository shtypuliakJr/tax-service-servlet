select rr.*, u.first_name, u.last_name, u.ipn
FROM (
         select r.*
         from report r
         WHERE r.user_id = (CASE WHEN 5 IS NULL THEN r.user_id ELSE 5 END)
     ) rr
         left join user u on rr.user_id = u.id;


SELECT rr.*, u.first_name, u.last_name, u.ipn
FROM (SELECT * FROM report r WHERE user_id = 5) rr
    LEFT JOIN user u ON rr.user_id = u.id;