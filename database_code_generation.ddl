-- Generated by Oracle SQL Developer Data Modeler 18.4.0.339.1532
--   at:        2019-04-14 12:43:48 CEST
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



CREATE TABLE amenities (
    amenity    CHAR(20) NOT NULL,
    "access"   CHAR(20)
);

ALTER TABLE amenities ADD CONSTRAINT amenities_pk PRIMARY KEY ( amenity );

CREATE TABLE beds (
    bed_type CHAR(20) NOT NULL
);

ALTER TABLE beds ADD CONSTRAINT beds_pk PRIMARY KEY ( bed_type );

CREATE TABLE booking_policy (
    id                              INTEGER NOT NULL,
    extra_people                    INTEGER,
    is_business_travel_ready        CHAR(1),
    require_guest_profile_picture   CHAR(1),
    maximum_nights                  INTEGER,
    minimum_nights                  INTEGER,
    cancellation_policy             CHAR(500),
    guests_included                 INTEGER
);

ALTER TABLE booking_policy ADD CONSTRAINT booking_policy_pk PRIMARY KEY ( id );

ALTER TABLE booking_policy ADD CONSTRAINT booking_policy_id_un UNIQUE ( id );

CREATE TABLE calendar (
    "date"       DATE NOT NULL,
    listing_id   INTEGER NOT NULL,
    available    CHAR(1),
    price        INTEGER
);

ALTER TABLE calendar ADD CONSTRAINT calendar_pk PRIMARY KEY ( "date",
                                                              listing_id );

CREATE TABLE date_informations (
    id                    INTEGER NOT NULL,
    "date"                DATE NOT NULL,
    calendar_listing_id   INTEGER NOT NULL
);

ALTER TABLE date_informations ADD CONSTRAINT date_informations_pk PRIMARY KEY ( "date",
                                                                                id );

CREATE TABLE has_amenities (
    amenity      CHAR(20) NOT NULL,
    listing_id   INTEGER NOT NULL
);

ALTER TABLE has_amenities ADD CONSTRAINT has_amenities_pk PRIMARY KEY ( amenity,
                                                                        listing_id );

CREATE TABLE has_beds (
    longitude       INTEGER NOT NULL,
    latitude        INTEGER NOT NULL,
    neighbourhood   CHAR(20) NOT NULL,
    bed_type        CHAR(20) NOT NULL
);

ALTER TABLE has_beds
    ADD CONSTRAINT has_beds_pk PRIMARY KEY ( longitude,
                                             latitude,
                                             neighbourhood,
                                             bed_type );

CREATE TABLE has_verifications (
    verification_type   CHAR(20) NOT NULL,
    url                 CHAR(100) NOT NULL
);

ALTER TABLE has_verifications ADD CONSTRAINT has_verifications_pk PRIMARY KEY ( verification_type,
                                                                                url );

CREATE TABLE hosts (
    url             CHAR(100) NOT NULL,
    id_listings     INTEGER NOT NULL,
    id_user         INTEGER NOT NULL,
    since           DATE,
    about           CHAR(500),
    thumbnail_url   CHAR(100),
    response_time   CHAR(20)
);

ALTER TABLE hosts ADD CONSTRAINT hosts_pk PRIMARY KEY ( url );

ALTER TABLE hosts ADD CONSTRAINT hosts_id_un UNIQUE ( id_listings );

CREATE TABLE house (
    neighbourhood   CHAR(20) NOT NULL,
    longitude       INTEGER NOT NULL,
    latitude        INTEGER NOT NULL,
    listings_id     INTEGER NOT NULL,
    beds            INTEGER,
    space           CHAR(100),
    property_type   CHAR(20),
    room_type       CHAR(20),
    bed_type        CHAR(20),
    house_rules     CHAR(200),
    accommodates    INTEGER,
    square_feet     INTEGER,
    bathrooms       INTEGER,
    bedrooms        INTEGER
);

ALTER TABLE house
    ADD CONSTRAINT house_pk PRIMARY KEY ( longitude,
                                          latitude,
                                          neighbourhood );

CREATE TABLE listings (
    id                       INTEGER NOT NULL,
    name                     CHAR(20),
    url                      CHAR(100),
    space                    CHAR(100),
    interaction              CHAR(100),
    notes                    CHAR(100),
    picture_url              CHAR(100),
    description              CHAR(500),
    neighbourhood_overview   CHAR(100),
    summary                  CHAR(500),
    transit                  CHAR(100),
    place                    CHAR(20)
);

ALTER TABLE listings ADD CONSTRAINT listings_pk PRIMARY KEY ( id );

CREATE TABLE location (
    latitude       INTEGER NOT NULL,
    longitude      INTEGER NOT NULL,
    id             INTEGER NOT NULL,
    country        CHAR(20),
    country_code   INTEGER,
    city           CHAR(20)
);

ALTER TABLE location ADD CONSTRAINT location_pk PRIMARY KEY ( latitude,
                                                              longitude );

ALTER TABLE location ADD CONSTRAINT location_id_un UNIQUE ( id );

CREATE TABLE pricing (
    id                 INTEGER
        CONSTRAINT nnc_pricing_id NOT NULL,
    price              INTEGER,
    cleaning_fee       INTEGER,
    security_deposit   INTEGER,
    monthly_price      INTEGER,
    weekly_price       INTEGER
);

ALTER TABLE pricing ADD CONSTRAINT pricing_pk PRIMARY KEY ( id );

ALTER TABLE pricing ADD CONSTRAINT pricing_id_un UNIQUE ( id );

CREATE TABLE review (
    listings_id     INTEGER NOT NULL,
    reviewer_id     INTEGER NOT NULL,
    id              INTEGER NOT NULL,
    reviewer_name   CHAR(50),
    "date"          DATE,
    comments        CHAR(1000)
);

ALTER TABLE review
    ADD CONSTRAINT review_pk PRIMARY KEY ( listings_id,
                                           reviewer_id,
                                           id );

CREATE TABLE review_scores (
    id              INTEGER NOT NULL,
    value           INTEGER,
    checking        INTEGER,
    rating          INTEGER,
    location        INTEGER,
    accuracy        INTEGER,
    communication   INTEGER,
    cleanliness     INTEGER
);

ALTER TABLE review_scores ADD CONSTRAINT review_scores_pk PRIMARY KEY ( id );

ALTER TABLE review_scores ADD CONSTRAINT review_scores_id_un UNIQUE ( id );

CREATE TABLE "USER" (
    id     INTEGER NOT NULL,
    name   CHAR(50)
);

ALTER TABLE "USER" ADD CONSTRAINT user_pk PRIMARY KEY ( id );

CREATE TABLE verifications (
    verification_type CHAR(20) NOT NULL
);

ALTER TABLE verifications ADD CONSTRAINT verifications_pk PRIMARY KEY ( verification_type );

ALTER TABLE booking_policy
    ADD CONSTRAINT booking_policy_listings_fk FOREIGN KEY ( id )
        REFERENCES listings ( id )
            ON DELETE CASCADE;

ALTER TABLE date_informations
    ADD CONSTRAINT date_informations_calendar_fk FOREIGN KEY ( "date",
                                                               calendar_listing_id )
        REFERENCES calendar ( "date",
                              listing_id );

ALTER TABLE date_informations
    ADD CONSTRAINT date_informations_listings_fk FOREIGN KEY ( id )
        REFERENCES listings ( id );

ALTER TABLE has_amenities
    ADD CONSTRAINT has_amenities_amenities_fk FOREIGN KEY ( amenity )
        REFERENCES amenities ( amenity );

ALTER TABLE has_amenities
    ADD CONSTRAINT has_amenities_listings_fk FOREIGN KEY ( listing_id )
        REFERENCES listings ( id );

ALTER TABLE has_beds
    ADD CONSTRAINT has_beds_beds_fk FOREIGN KEY ( bed_type )
        REFERENCES beds ( bed_type );

ALTER TABLE has_beds
    ADD CONSTRAINT has_beds_house_fk FOREIGN KEY ( longitude,
                                                   latitude,
                                                   neighbourhood )
        REFERENCES house ( longitude,
                           latitude,
                           neighbourhood );

ALTER TABLE has_verifications
    ADD CONSTRAINT has_verifications_hosts_fk FOREIGN KEY ( url )
        REFERENCES hosts ( url );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE has_verifications
    ADD CONSTRAINT has_verifications_verifications_fk FOREIGN KEY ( verification_type )
        REFERENCES verifications ( verification_type );

ALTER TABLE hosts
    ADD CONSTRAINT hosts_listings_fk FOREIGN KEY ( id_listings )
        REFERENCES listings ( id );

ALTER TABLE hosts
    ADD CONSTRAINT hosts_user_fk FOREIGN KEY ( id_user )
        REFERENCES "USER" ( id );

ALTER TABLE house
    ADD CONSTRAINT house_listings_fk FOREIGN KEY ( listings_id )
        REFERENCES listings ( id );

ALTER TABLE house
    ADD CONSTRAINT house_location_fk FOREIGN KEY ( latitude,
                                                   longitude )
        REFERENCES location ( latitude,
                              longitude )
            ON DELETE CASCADE;

ALTER TABLE location
    ADD CONSTRAINT location_listings_fk FOREIGN KEY ( id )
        REFERENCES listings ( id );

ALTER TABLE pricing
    ADD CONSTRAINT pricing_listings_fk FOREIGN KEY ( id )
        REFERENCES listings ( id )
            ON DELETE CASCADE;

ALTER TABLE review
    ADD CONSTRAINT review_listings_fk FOREIGN KEY ( listings_id )
        REFERENCES listings ( id );

ALTER TABLE review_scores
    ADD CONSTRAINT review_scores_listings_fk FOREIGN KEY ( id )
        REFERENCES listings ( id )
            ON DELETE CASCADE;

ALTER TABLE review
    ADD CONSTRAINT review_user_fk FOREIGN KEY ( reviewer_id )
        REFERENCES "USER" ( id );

SELECT AVG(p.price)
FROM pricing p, house h
WHERE h.bedrooms >= 8 AND p.pricing_listings_fk = h.listings_id;

SELECT  AVG(review_scores.rating)
FROM review_scores rs, amenities a, listings l, has_amenities ra
WHERE (a.amenity LIKE '%TV%'
        OR a.amenity LIKE '%Television%'
        OR l.summary LIKE '%TV%'
        OR l.summary LIKE '%Television%')
        AND (
             (a.amenities_pk = ra.amenity AND ra.has_amenities_listings_fk = rs.review_scores_listings_fk)
            OR l.id = rs.review_scores_listings_fk);

SELECT  h.*
FROM hosts h, calendar c, date_informations d
WHERE h.hosts_listings_fk = d.date_informations_listings_fk
    AND c.calendar_pk = d.calendar_listing_id
    AND YEAR(c."date") = 2019 AND 3<=MONTH(c."date")<=9;


SELECT COUNT(h1.id_listings)
FROM "USER" u1, "USER" u2, hosts h1
WHERE u1.name = u2.name AND u1.id != u2.id AND (h1.id_user = u1.id OR h1.id_user = u2.id);

SELECT c."date"
FROM calendar c, date_informations d, listings l, hosts h
WHERE h.url LIKE '%Viajes Eco%'
    AND h.id_listings = c.listing_id
    AND c.available = 't';

SELECT (u.id_user, u.name)
FROM "USER" u,
     (SELECT h.id
FROM hosts h, "USER" u
GROUP BY h.id_user
HAVING COUNT(*) = 1
)h
WHERE u.id = h.id;



-- Oracle SQL Developer Data Modeler Summary Report:
-- 
-- CREATE TABLE                            17
-- CREATE INDEX                             0
-- ALTER TABLE                             40
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   1
-- WARNINGS                                 0
