-- --------------------------------------------------------

-- Table structure for table `brands`
--

CREATE TABLE `brands`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

-- Table structure for table `categories`
--

CREATE TABLE `categories`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `name`      varchar(255) DEFAULT NULL,
    `parent_id` int(11) DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

-- Table structure for table `colors`
--

CREATE TABLE `colors`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `color` varchar(255) DEFAULT NULL,
    `name`  varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

-- Table structure for table `files`
--

CREATE TABLE `files`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `name`       varchar(255) DEFAULT NULL,
    `capacity`   bigint(20) DEFAULT NULL,
    `file_path`  varchar(255) DEFAULT NULL,
    `created_at` bigint(20) DEFAULT NULL,
    `updated_at` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

-- Table structure for table `products`
--

CREATE TABLE `products`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) DEFAULT NULL,
    `price` double DEFAULT NULL,
    `description` longtext     DEFAULT NULL,
    `brand_id`    int(11) DEFAULT NULL,
    `created_at`  bigint(20) DEFAULT NULL,
    `updated_at`  bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

-- Table structure for table `products_in_categories`
--

CREATE TABLE `products_in_categories`
(
    `product_id`  int(11) NOT NULL,
    `category_id` int(11) NOT NULL,
    PRIMARY KEY (`product_id`, `category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

-- Table structure for table `sizes`
--

CREATE TABLE `sizes`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `size` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

-- Table structure for table `variants`
--

CREATE TABLE `variants`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `product_id` int(11) DEFAULT NULL,
    `quantity`   int(11) DEFAULT NULL,
    `color_id`   int(11) DEFAULT NULL,
    `size_id`    int(11) DEFAULT NULL,
    `created_at` bigint(20) DEFAULT NULL,
    `updated_at` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

-- Table structure for table `variant_file`
--

CREATE TABLE `variant_file`
(
    `variant_id` int(11) NOT NULL,
    `file_id`    int(11) NOT NULL,
    PRIMARY KEY (`variant_id`, `file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
