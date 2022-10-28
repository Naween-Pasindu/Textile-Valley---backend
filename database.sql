-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: tourx.cft49dmwpe66.ap-southeast-1.rds.amazonaws.com
-- Generation Time: Oct 28, 2022 at 03:49 PM
-- Server version: 10.6.10-MariaDB-log
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Textile-Valley`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyer`
--

CREATE TABLE `buyer` (
                         `userId` int(4) NOT NULL,
                         `fullName` varchar(100) NOT NULL,
                         `address` varchar(100) NOT NULL,
                         `contact` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
                        `cartId` int(3) NOT NULL,
                        `buyerId` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cartItem`
--

CREATE TABLE `cartItem` (
                            `cartId` int(3) NOT NULL,
                            `itemId` int(4) NOT NULL,
                            `size` int(1) NOT NULL,
                            `quantity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
                        `itemId` int(4) NOT NULL,
                        `itemName` varchar(100) NOT NULL,
                        `seller` int(4) NOT NULL,
                        `price` decimal(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `itemQuantity`
--

CREATE TABLE `itemQuantity` (
                                `itemId` int(4) NOT NULL,
                                `itemQuantity` int(3) NOT NULL,
                                `itemSize` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
                         `userId` int(4) NOT NULL,
                         `roleId` int(1) NOT NULL,
                         `emailEncrypted` varchar(100) NOT NULL,
                         `emailHashed` varchar(100) NOT NULL,
                         `passwordHashed` varchar(100) NOT NULL,
                         `userName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `orderItem`
--

CREATE TABLE `orderItem` (
                             `orderId` int(4) NOT NULL,
                             `itemId` int(4) NOT NULL,
                             `size` int(1) NOT NULL,
                             `requiredQuantity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `orderRecord`
--

CREATE TABLE `orderRecord` (
                               `recordId` int(4) NOT NULL,
                               `customer` int(4) NOT NULL,
                               `createdTime` datetime DEFAULT current_timestamp(),
                               `customAddress` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
                           `recordId` int(5) NOT NULL,
                           `orderId` int(4) DEFAULT NULL,
                           `paymentMethod` int(1) NOT NULL,
                           `paymentStatus` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seller`
--

CREATE TABLE `seller` (
                          `userId` int(4) NOT NULL,
                          `fullName` varchar(100) NOT NULL,
                          `storeAddress` varchar(100) NOT NULL,
                          `contact` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seller`
--

INSERT INTO `seller` (`userId`, `fullName`, `storeAddress`, `contact`) VALUES
    (1, 'GHJ', 'DFG', '0123456789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyer`
--
ALTER TABLE `buyer`
    ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `address` (`address`),
  ADD UNIQUE KEY `contact` (`contact`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
    ADD PRIMARY KEY (`cartId`),
  ADD KEY `buyerId` (`buyerId`);

--
-- Indexes for table `cartItem`
--
ALTER TABLE `cartItem`
    ADD PRIMARY KEY (`cartId`,`itemId`,`size`),
  ADD KEY `itemId` (`itemId`,`size`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
    ADD PRIMARY KEY (`itemId`),
  ADD KEY `seller` (`seller`);

--
-- Indexes for table `itemQuantity`
--
ALTER TABLE `itemQuantity`
    ADD PRIMARY KEY (`itemId`,`itemSize`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
    ADD PRIMARY KEY (`userId`,`roleId`);

--
-- Indexes for table `orderItem`
--
ALTER TABLE `orderItem`
    ADD PRIMARY KEY (`orderId`,`itemId`,`size`),
  ADD KEY `itemId` (`itemId`,`size`);

--
-- Indexes for table `orderRecord`
--
ALTER TABLE `orderRecord`
    ADD PRIMARY KEY (`recordId`),
  ADD KEY `customer` (`customer`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
    ADD PRIMARY KEY (`recordId`),
  ADD KEY `orderId` (`orderId`);

--
-- Indexes for table `seller`
--
ALTER TABLE `seller`
    ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `storeAddress` (`storeAddress`),
  ADD UNIQUE KEY `contact` (`contact`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyer`
--
ALTER TABLE `buyer`
    MODIFY `userId` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
    MODIFY `cartId` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
    MODIFY `itemId` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orderRecord`
--
ALTER TABLE `orderRecord`
    MODIFY `recordId` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
    MODIFY `recordId` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `seller`
--
ALTER TABLE `seller`
    MODIFY `userId` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
    ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`userId`);

--
-- Constraints for table `cartItem`
--
ALTER TABLE `cartItem`
    ADD CONSTRAINT `cartItem_ibfk_1` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`),
  ADD CONSTRAINT `cartItem_ibfk_2` FOREIGN KEY (`itemId`,`size`) REFERENCES `itemQuantity` (`itemId`, `itemSize`) ON DELETE CASCADE;

--
-- Constraints for table `item`
--
ALTER TABLE `item`
    ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`seller`) REFERENCES `seller` (`userId`);

--
-- Constraints for table `itemQuantity`
--
ALTER TABLE `itemQuantity`
    ADD CONSTRAINT `itemQuantity_ibfk_1` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`);

--
-- Constraints for table `orderItem`
--
ALTER TABLE `orderItem`
    ADD CONSTRAINT `orderItem_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orderRecord` (`recordId`),
  ADD CONSTRAINT `orderItem_ibfk_2` FOREIGN KEY (`itemId`,`size`) REFERENCES `itemQuantity` (`itemId`, `itemSize`) ON DELETE CASCADE;

--
-- Constraints for table `orderRecord`
--
ALTER TABLE `orderRecord`
    ADD CONSTRAINT `orderRecord_ibfk_1` FOREIGN KEY (`customer`) REFERENCES `buyer` (`userId`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
    ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orderRecord` (`recordId`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
