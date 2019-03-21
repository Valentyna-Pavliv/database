-- listings entity
CREATE TABLE LISTINGS (
  id INT,
  name CHAR(20),
  url CHAR(100),price
  space CHAR(500),
  interaction CHAR(500),
  notes CHAR(500),
  picture_url CHAR(200),
  describtion CHAR(1000),
  neighborhood_overview CHAR(500),
  summary CHAR(500),
  transit CHAR(500),
  PRIMARY KEY (id)
  );
  
-- listings / pricing relation 
CREATE TABLE COSTS_PRICING (
  price INT,
  cleaning_fee INT,
  security_deposit INT,
  monthly_price INT,
  weekly_price,
  id INT UNIQUE NOT NULL,
  PRIMARY KEY (id),  
  FOREIGN KEY (id) REFERENCES LISTINGS(id) ON DELETE CASCADE
  );
  
-- CHANGE: REVIEW "exactly one" review "partial" LISTINGS 
-- listings / review_scores relation
CREATE TABLE REVIEW_SCORES (
  value INT,
  checking INT,
  rating INT,
  location INT,
  accuracy INT,
  communication INT,
  cleanliness INT,
  id INT NOT NULL,
  PRIMARY KEY (value, id),
  FOREIGN KEY (id) REFERENCES LISTINGS(id) ON DELETE CASCADE
);  

-- listings / booking_policy relation
CREATE TABLE REQUIRES_BOOKING_POLICY (
  extra_people INT,
  is_business_travel_ready BOOLEAN,
  require_quest_profil_picture BOOLEAN,
  maxium_nights INT,
  minimum_nights INT,
  cancellation_policy CHAR(500),
  guests_included INT,
  id INT UNIQUE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES LISTINGS(id) ON DELETE CASCADE
  );
  
-- listings / location relation
CREATE TABLE LOCATION (
  longitude INT,
  latitude INT,
  city CHAR(20),
  country_code INT,
  country CHAR(20),
  id INT UNIQUE,
  PRIMARY KEY (longitude, latitude),
  FOREIGN KEY (id) REFERENCES LISTINGS(id)
  );

-- CHANGE: underline neighbourhood
-- location / house relation
CREATE TABLE IN_HOUSE (
  beds INT,
  space CHAR(200),
  property_type CHAR (20),
  room_type CHAR (20),
  bed_type CHAR(20),
  neighbourhood CHAR(20),
  house_rules CHAR (200),
  accomodates INT,
  square_feet INT,
  bathrooms INT,
  bedrooms INT,
  longitude INT,
  latitude INT,
  PRIMARY KEY (neighbourhood, longitude, latitude),
  FOREIGN KEY (latiutude, longitude) REFERENCES LISTINGS(latiutude, longitude) ON DELETE CASCADE
  );
 
-- listings / amenities relation  
CREATE TABLE HAS_AMENITIES (
  amenities CHAR(200),
  access CHAR(200),
  id INT UNIQUE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES LISTINGS(id) ON DELETE CASCADE
  );  
  
  
  
-- TODO: How to deal with the ISA relationship ?
-- listings / host relation
CREATE TABLE HOST ( -- todo finish
  since DATE,
  about CHAR(500),
  url CHAR(100),
  neighborhood CHAR(50),
  thumbnail_url CHAR(100),
  verifications CHAR(200), -- maybe change CHAR for list
  response_time INT
  id INT UNIQUE,
  
  );
  
  