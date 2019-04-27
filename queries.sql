SELECT AVG(c.price)
FROM calendars c, houses h
WHERE h.bedrooms >= 8 AND c.id_listing = h.id_listing;

SELECT AVG(rs.rating)
FROM review_scores rs, amenities a, listings l, has_amenities ra
WHERE (a.amenity_type LIKE '%TV%'
        OR a.amenity_type LIKE '%Television%'
        OR l.summary LIKE '%TV%'
        OR l.summary LIKE '%Television%')
        AND ((rs.id_listing =ra.id_listing AND a.amenity_type = ra.amenity_type)
              OR l.id_listing = rs.id_listing);

SELECT  h.*
FROM hosts h, calendars c
WHERE h.id_listing = c.id_listing
    AND YEAR(c.date) = 2019 AND 3<= MONTH(c.date) AND MONTH(c.date) <= 9;


SELECT COUNT(h1.id_listing)
FROM users u1, users u2, hosts h1
WHERE u1.name = u2.name AND u1.id_user != u2.id_user AND (h1.id_user = u1.id_user OR h1.id_user = u2.id_user);

SELECT c.date
FROM calendars c, hosts h
WHERE h.url LIKE '%Viajes Eco%'
    AND h.id_listing = c.id_listing
    AND c.available = 't';

SELECT (u.id_user, u.name)
FROM users u,
     (SELECT h.id_user
FROM hosts h, users u
GROUP BY h.id_user
HAVING COUNT(*) = 1
)h
WHERE u.id_user = h.id_user;

SELECT withWifi.avgWithWifi - withoutWifi.avgWithoutWifi
FROM (SELECT AVG(c.price) AS avgWithWifi
        FROM calendars c, amenities a, has_amenities ha
        WHERE (a.amenity_type LIKE '%Wifi%'
            OR a.amenity_type LIKE '%WIFI%')
            AND ha.amenity_type = a.amenity_type AND ha.id_listing = c.id_listing) withWifi ,
     (SELECT AVG(c.price) avgWithoutWifi
        FROM calendars c, amenities a, has_amenities ha
        WHERE (NOT a.amenity_type LIKE '%Wifi%'
            AND NOT a.amenity_type LIKE '%WIFI%')
            AND ha.amenity_type = a.amenity_type AND ha.id_listing = c.id_listing) withoutWifi;

SELECT madridPricing.avgMadrid - berlinPricing.avgBerlin
FROM (SELECT AVG(c.price) AS  avgMadrid
      FROM calendars c,
           houses h,
           locations l
      WHERE h.beds = 8
        AND l.city LIKE '%Madrid%'
        AND l.id_listing = h.id_listing
        AND c.id_listing = h.id_listing
    )madridPricing ,
     (SELECT AVG(c.price) AS avgBerlin
      FROM calendars c,
           houses h,
           locations l
      WHERE h.beds = 8
        AND l.city LIKE '%Berlin%'
        AND l.id_listing = h.id_listing
        AND c.id_listing = h.id_listing
    )berlinPricing;

SELECT(u.id_user, u.name)
FROM users u
     INNER JOIN (SELECT id_user, count(id_user) as cnt
                     FROM hosts
                    GROUP BY id_user) cou ON u.id_user = cou.id_user
                    ORDER BY cnt DESC
                    LIMIT 10;

SELECT (l.id_listing, l.name)
FROM listings l
     RIGHT JOIN (SELECT id_listing FROM review_scores rs) s ON l.id_listing = s.id_listing
        INNER JOIN (SELECT id_listing, count(id_listing) as cnt
                    FROM review_scores rs
                    GROUP BY id_listing) cou ON l.id_listing = cou.id_listing
                    ORDER BY cnt DESC
                    LIMIT 10;
