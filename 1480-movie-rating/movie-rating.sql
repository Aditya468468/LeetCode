SELECT 
    min(name) as results 
FROM (
SELECT
    u.name as name 
FROM MovieRating m
INNER JOIN Users u
ON m.user_id = u.user_id
GROUP BY m.user_id,u.name
HAVING COUNT(*)=
        (
            SELECT 
            MAX(cnt) count
            FROM 
            (
                SELECT 
                COUNT(*) AS cnt
                FROM MovieRating
                GROUP BY user_id
            ) AS t
        )
) as result

UNION ALL -- Rebecca and Rebecca --> WILL GIVE ONLY ONE Rebecca After UNION

SELECT
    MIN(title) as results 
FROM(
SELECT
    m.title as title
FROM Movies m
INNER JOIN MovieRating mr
ON m.movie_id=mr.movie_id
WHERE MONTH(mr.created_at) = 2 AND YEAR(mr.created_at) = 2020
GROUP BY mr.movie_id,m.title
HAVING ROUND(AVG(mr.rating),4)=(
SELECT
    ROUND(max(avg_rating),4) rating
FROM(
SELECT
    AVG(rating) AS avg_rating
FROM MovieRating
WHERE MONTH(created_at)=2 AND YEAR(created_at)=2020
GROUP BY movie_id
) As rating
)
) AS title


