WITH unique_region AS
(
    SELECT
    lat,
    lon
    FROM Insurance
    GROUP BY lat,lon
    HAVING COUNT(*)=1
),
unique_record AS 
(
    SELECT
        i.pid,
        i.tiv_2015,
        i.tiv_2016,
        r.lat,
        r.lon
    FROM Insurance i
    JOIN unique_region r
    ON i.lat=r.lat AND i.lon=r.lon
)
SELECT 
    ROUND(SUM(u1.tiv_2016),2) AS tiv_2016
FROM unique_record u1
WHERE EXISTS 
        (
            SELECT 1
            FROM Insurance u2
            WHERE u1.pid!=u2.pid AND u1.tiv_2015=u2.tiv_2015
        )
