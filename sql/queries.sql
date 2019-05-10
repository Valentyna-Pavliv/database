
SELECT AVG(c.price)
FROM calendars c, houses h
WHERE h.bedrooms >= 8 AND c.id_listing = h.id_listing;

SELECT AVG(rs.rating)
FROM review_scores rs, amenities a, has_amenities ra
WHERE (a.amenity_type LIKE '%TV%'
        OR a.amenity_type LIKE '%Television%')
        AND rs.id_listing =ra.id_listing AND a.amenity_type = ra.amenity_type;

SELECT DISTINCT u.user_name , u.id_user
 FROM calendars c, listings l , users u
 WHERE c.calendar_date >= '2019-03-01' AND c.calendar_date < '2019-10-01' AND c.available LIKE '%t%'
 AND l.id_listing = c.id_listing AND l.host_id = u.id_user ;

 SELECT COUNT(l1.hosts_id)
 FROM users u1, users u2, listing l1, listings l2
 WHERE l1.hosts_id != l2.id_user AND u1.name = u2.name AND l1.hosts_id = u1.id_user AND u2.id_user = l2.hosts_id

SELECT c.calendar_date
FROM calendars c, hosts h, users u
WHERE u.user_name LIKE '%Viajes Eco%'
    AND u.id_listing = h.id_listing
    AND h.id_listing = c.id_listing
    AND c.available = 't';

SELECT (u.id_user, u.user_name)
FROM users u,
     (SELECT l.host_id as id
FROM listings l
GROUP BY l.host_id
HAVING COUNT(*) = 1)h
WHERE u.id_user = h.id;

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


CREATE INDEX index_calendars ON calendars(calendar_date);
CREATE INDEX index_amenities ON amenities(amenity_type);
CREATE INDEX index_listings_summary ON listings(summary);


  SELECT (u.id_user, u.user_name)
  FROM users u,
       (SELECT l.host_id as id
  FROM listings l
  GROUP BY l.host_id
  HAVING COUNT(*) = 1
  )h
  WHERE u.id_user = h.id;

  SELECT(u.id_user, u.name)
  FROM users u
       INNER JOIN (SELECT id_user, count(id_user) as cnt
                       FROM hosts
                      GROUP BY id_user) cou ON u.id_user = cou.id_user
                      ORDER BY cnt DESC
                      LIMIT 10;

  SELECT (l.id_listing, l.name_listing)
  FROM listings l
       RIGHT JOIN (SELECT id_listing FROM review_scores rs) s ON l.id_listing = s.id_listing
          INNER JOIN (SELECT id_listing, count(id_listing) as cnt
                      FROM review_scores rs
                      GROUP BY id_listing) cou ON l.id_listing = cou.id_listing
                      ORDER BY cnt DESC
                      LIMIT 10;
