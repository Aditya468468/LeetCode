SELECT x,y,z,
        CASE 
            WHEN x+y>z AND z+x>y AND y+z>x THEN 'Yes' -- Sum of every two sides > thrid side.
            ELSE 'No'
        END AS triangle
FROM Triangle;
