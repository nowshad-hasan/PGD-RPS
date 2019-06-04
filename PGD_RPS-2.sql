-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 12, 2017 at 07:28 AM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `PGD_RPS`
--

-- --------------------------------------------------------

--
-- Table structure for table `course_session_table`
--

CREATE TABLE `course_session_table` (
  `course_session_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `session_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course_table`
--

CREATE TABLE `course_table` (
  `course_id` int(10) NOT NULL,
  `course_name` varchar(100) NOT NULL,
  `course_credit` int(10) NOT NULL,
  `semester` varchar(100) NOT NULL,
  `current_semester_status` varchar(100) NOT NULL,
  `user_id` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_table`
--

INSERT INTO `course_table` (`course_id`, `course_name`, `course_credit`, `semester`, `current_semester_status`, `user_id`) VALUES
(1, 'C Theory', 3, '1', 'yes', 3),
(2, 'Java', 3, '2', 'yes', 4),
(3, 'Networking', 2, '4', 'yes', 2),
(4, 'Data Structure', 3, '3', 'yes', 3),
(5, 'Algorithm', 3, '2', 'yes', 4),
(6, 'Compiler', 2, '3', 'yes', 2);

-- --------------------------------------------------------

--
-- Table structure for table `result_table`
--

CREATE TABLE `result_table` (
  `result_id` int(100) NOT NULL,
  `student_id` int(11) NOT NULL,
  `session_year` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `attendance` int(11) NOT NULL,
  `term_test` int(11) NOT NULL,
  `final_exam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result_table`
--

INSERT INTO `result_table` (`result_id`, `student_id`, `session_year`, `course_id`, `attendance`, `term_test`, `final_exam`) VALUES
(1, 1, 2012, 3, 25, 17, 50),
(2, 6, 2012, 3, 20, 18, 45),
(3, 7, 2012, 3, 15, 20, 60),
(4, 3, 2012, 4, 12, 15, 65),
(5, 1, 2012, 5, 8, 10, 40),
(6, 3, 2012, 5, 7, 15, 45),
(7, 6, 2012, 5, 9, 12, 50),
(8, 7, 2012, 5, 10, 15, 60),
(9, 2, 2014, 1, 5, 12, 60),
(10, 4, 2014, 1, 7, 10, 45),
(11, 5, 2013, 3, 8, 14, 55);

-- --------------------------------------------------------

--
-- Table structure for table `role_table`
--

CREATE TABLE `role_table` (
  `role_id` int(10) NOT NULL,
  `role_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role_table`
--

INSERT INTO `role_table` (`role_id`, `role_name`) VALUES
(1, 'admin'),
(2, 'teacher'),
(3, 'office');

-- --------------------------------------------------------

--
-- Table structure for table `session_table`
--

CREATE TABLE `session_table` (
  `session_id` int(10) NOT NULL,
  `session_year` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_table`
--

CREATE TABLE `student_table` (
  `student_id` int(10) NOT NULL,
  `student_name` varchar(100) NOT NULL,
  `student_dept` varchar(100) NOT NULL,
  `student_reg` varchar(100) NOT NULL,
  `student_session` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_table`
--

INSERT INTO `student_table` (`student_id`, `student_name`, `student_dept`, `student_reg`, `student_session`) VALUES
(1, 'Shamim', 'cse', '201234', 2012),
(2, 'Rafi', 'eee', '201252', 2014),
(3, 'Tanvir', 'eee', '201201', 2012),
(4, 'Shuvo', 'iict', '201250', 2014),
(5, 'Tuhin', 'cse', '201321', 2013),
(6, 'Saddam', 'cse', '201233', 2012),
(7, 'Moqsad', 'cse', '201220', 2012);

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `user_id` int(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `role_id` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`user_id`, `user_name`, `user_email`, `user_password`, `role_id`) VALUES
(1, 'nowshad', 'nowshadapu@gmail.com', '12', 1),
(2, 'abc', 'abc@gmail.com', '12', 2),
(3, 'def', 'def@gmail.com', '12', 2),
(4, 'xyz', 'xyz@gmail.com', '12', 2),
(5, 'sust cse', 'sustcse21st@gmail.com', '12345', 2),
(6, 'sdrfgdsf ', 'sustcse21st@gmail.com', 'sdrflkdfg', 2),
(7, 'sust cse', 'sustcse21st@gmail.com', 'jgfhgvfj', 2),
(8, 'sust cse', 'sustcse21st@gmail.com', 'mhgfh', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course_session_table`
--
ALTER TABLE `course_session_table`
  ADD PRIMARY KEY (`course_session_id`),
  ADD KEY `course_id` (`course_id`),
  ADD KEY `session_id` (`session_id`);

--
-- Indexes for table `course_table`
--
ALTER TABLE `course_table`
  ADD PRIMARY KEY (`course_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `result_table`
--
ALTER TABLE `result_table`
  ADD PRIMARY KEY (`result_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `course_id` (`course_id`);

--
-- Indexes for table `role_table`
--
ALTER TABLE `role_table`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `session_table`
--
ALTER TABLE `session_table`
  ADD PRIMARY KEY (`session_id`);

--
-- Indexes for table `student_table`
--
ALTER TABLE `student_table`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course_session_table`
--
ALTER TABLE `course_session_table`
  MODIFY `course_session_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `course_table`
--
ALTER TABLE `course_table`
  MODIFY `course_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `result_table`
--
ALTER TABLE `result_table`
  MODIFY `result_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `role_table`
--
ALTER TABLE `role_table`
  MODIFY `role_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `session_table`
--
ALTER TABLE `session_table`
  MODIFY `session_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student_table`
--
ALTER TABLE `student_table`
  MODIFY `student_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `course_session_table`
--
ALTER TABLE `course_session_table`
  ADD CONSTRAINT `course_session_id_fk1` FOREIGN KEY (`course_id`) REFERENCES `course_table` (`course_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `course_session_id_fk2` FOREIGN KEY (`session_id`) REFERENCES `session_table` (`session_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `course_table`
--
ALTER TABLE `course_table`
  ADD CONSTRAINT `user_course_fk` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `result_table`
--
ALTER TABLE `result_table`
  ADD CONSTRAINT `result_course_fk` FOREIGN KEY (`course_id`) REFERENCES `course_table` (`course_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `result_student_fk` FOREIGN KEY (`student_id`) REFERENCES `student_table` (`student_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `user_table`
--
ALTER TABLE `user_table`
  ADD CONSTRAINT `user_role_fk` FOREIGN KEY (`role_id`) REFERENCES `role_table` (`role_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
