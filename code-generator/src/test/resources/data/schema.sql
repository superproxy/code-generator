drop TABLE  mbss_account if EXISTS ;
CREATE TABLE mbss_account (
  account_id int(11)  PRIMARY KEY  ,
  nickname varchar(50)  NOT NULL  ,
  icon_url longtext ,
  account_source smallint(6) DEFAULT '0'  ,
  package_channel varchar(50) DEFAULT NULL  ,
  created_datetime datetime NOT NULL  ,
  account_state smallint(4) NOT NULL DEFAULT '1',
  account_score int(11) DEFAULT '0'   ,
  is_joined_circle int(11) DEFAULT '0'  ,
  is_auth_post int(11) DEFAULT '0'
);



drop TABLE  mbss_video if EXISTS ;
CREATE TABLE mbss_video (
  pic_id bigint(20) PRIMARY KEY,
  video_url varchar(256) DEFAULT NULL  ,
  video_id int(50) NOT NULL,
  category_id int(11) DEFAULT NULL,
  video_state smallint(6) DEFAULT NULL  ,
  user_id int(11) NOT NULL,
  channel_name varchar(50) DEFAULT NULL,
  channel_summary varchar(256) DEFAULT NULL,
  cover_image varchar(256) DEFAULT NULL,
  channel_id int(11) DEFAULT NULL,
  channel_web_Id varchar(256) NOT NULL,
  length int(11) DEFAULT NULL,
  duration int(11) DEFAULT NULL,
  fid varchar(50) DEFAULT NULL ,
  creator int(11) DEFAULT NULL ,
  created_datetime datetime DEFAULT NULL
)

