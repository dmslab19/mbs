-- 영화
INSERT INTO movie (movie_name) VALUES ('어벤져스: 엔드게임');
INSERT INTO movie (movie_name) VALUES ('걸캅스');
INSERT INTO movie (movie_name) VALUES ('명탐정 피카츄');
INSERT INTO movie (movie_name) VALUES ('나의 특별한 형제');
INSERT INTO movie (movie_name) VALUES ('배심원들');
INSERT INTO movie (movie_name) VALUES ('호텔 뭄바이');
INSERT INTO movie (movie_name) VALUES ('라플라스의 마녀');
INSERT INTO movie (movie_name) VALUES ('뽀로로 극장판 보물섬 대모험');
INSERT INTO movie (movie_name) VALUES ('알라딘');

-- 사용자 (비밀번호: demo)
INSERT INTO usr (user_id, first_name, last_name, role_name, password)
VALUES ('Hong Gildong', '길동', '홍', 'USER', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK');
INSERT INTO usr (user_id, first_name, last_name, role_name, password)
VALUES ('Kim Chulsu', '철수', '김', 'USER', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK');
INSERT INTO usr (user_id, first_name, last_name, role_name, password)
VALUES ('Lee Meeyoung', '미영', '이', 'USER', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK');
INSERT INTO usr (user_id, first_name, last_name, role_name, password)
VALUES ('Je Sanghyun', '상현', '제', 'ADMIN', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK');
INSERT INTO usr (user_id, first_name, last_name, role_name, password)
VALUES ('Lee Chaeyun', '채윤', '이', 'ADMIN', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK');


-- 회의실 예약 가능일
-- movie_id = 1의 예약 가능 날짜
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE, 1, 10);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE + 1, 1, 10);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE - 1, 1, 10);

-- movie_id = 2의 예약 가능 날짜
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE, 2, 5);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE + 1, 2, 5);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE - 1, 2, 5);

-- movie_id = 3의 예약 가능 날짜
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE, 3, 7);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE + 1, 3, 7);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE - 1, 3, 7);

-- movie_id = 4의 예약 가능 날짜
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE, 4, 15);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE + 1, 4, 15);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE - 1, 4, 15);

-- movie_id = 5의 예약 가능 날짜
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE, 5, 6);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE + 1, 5, 6);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE - 1, 5, 6);

-- movie_id = 6의 예약 가능 날짜
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE, 6, 8);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE + 1, 6, 8);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE - 1, 6, 8);

-- movie_id = 7의 예약 가능 날짜
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE, 7, 10);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE + 1, 7, 10);
INSERT INTO available_movie (available_date, movie_id, seats) VALUES (CURRENT_DATE - 1, 7, 10);
