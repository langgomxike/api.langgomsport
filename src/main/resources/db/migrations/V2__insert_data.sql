--
-- Dumping data for table `brands`
--

INSERT INTO `brands` (`id`, `name`)
VALUES (1, 'Nike'),
       (2, 'Adidas'),
       (3, 'Puma'),
       (4, 'Under Armour'),
       (5, 'The North Face');

-- --------------------------------------------------------
--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`)
VALUES (1, 'Giày'),
       (2, 'Quần'),
       (3, 'Áo'),
       (4, 'Gậy leo núi'),
       (5, 'Phụ kiện thể thao');

-- --------------------------------------------------------
--
-- Dumping data for table `colors`
--

INSERT INTO `colors` (`id`, `color`, `name`)
VALUES (1, '#FF0000', 'Red'),
       (2, '#00FF00', 'Green'),
       (3, '#0000FF', 'Blue'),
       (4, '#FFFFFF', 'White'),
       (5, '#000000', 'Black');

-- --------------------------------------------------------
--
-- Dumping data for table `files`
--

INSERT INTO `files` (`id`, `name`, `capacity`, `file_path`, `created_at`, `updated_at`)
VALUES (1, 'giay_the_thao_nam_1.jpg', 2048, '/images/giay_the_thao_nam_1.jpg', 1696552800, 1696552800),
       (2, 'giay_the_thao_nam_2.jpg', 2048, '/images/giay_the_thao_nam_2.jpg', 1696552800, 1696552800),
       (3, 'giay_chay_bo_nu_1.jpg', 2048, '/images/giay_chay_bo_nu_1.jpg', 1696552800, 1696552800),
       (4, 'giay_chay_bo_nu_2.jpg', 2048, '/images/giay_chay_bo_nu_2.jpg', 1696552800, 1696552800),
       (5, 'giay_bong_da_nam_1.jpg', 2048, '/images/giay_bong_da_nam_1.jpg', 1696552800, 1696552800),
       (6, 'giay_bong_da_nam_2.jpg', 2048, '/images/giay_bong_da_nam_2.jpg', 1696552800, 1696552800),
       (7, 'giay_leo_nui_1.jpg', 2048, '/images/giay_leo_nui_1.jpg', 1696552800, 1696552800),
       (8, 'giay_leo_nui_2.jpg', 2048, '/images/giay_leo_nui_2.jpg', 1696552800, 1696552800),
       (9, 'giay_sneaker_nu_1.jpg', 2048, '/images/giay_sneaker_nu_1.jpg', 1696552800, 1696552800),
       (10, 'giay_sneaker_nu_2.jpg', 2048, '/images/giay_sneaker_nu_2.jpg', 1696552800, 1696552800),
       (11, 'quan_the_thao_nam_1.jpg', 2048, '/images/quan_the_thao_nam_1.jpg', 1696552800, 1696552800),
       (12, 'quan_the_thao_nam_2.jpg', 2048, '/images/quan_the_thao_nam_2.jpg', 1696552800, 1696552800),
       (13, 'quan_chay_bo_nu_1.jpg', 2048, '/images/quan_chay_bo_nu_1.jpg', 1696552800, 1696552800),
       (14, 'quan_chay_bo_nu_2.jpg', 2048, '/images/quan_chay_bo_nu_2.jpg', 1696552800, 1696552800),
       (15, 'quan_leo_nui_nam_1.jpg', 2048, '/images/quan_leo_nui_nam_1.jpg', 1696552800, 1696552800),
       (16, 'quan_leo_nui_nam_2.jpg', 2048, '/images/quan_leo_nui_nam_2.jpg', 1696552800, 1696552800),
       (17, 'quan_tap_gym_nam_1.jpg', 2048, '/images/quan_tap_gym_nam_1.jpg', 1696552800, 1696552800),
       (18, 'quan_tap_gym_nam_2.jpg', 2048, '/images/quan_tap_gym_nam_2.jpg', 1696552800, 1696552800),
       (19, 'quan_boi_nu_1.jpg', 2048, '/images/quan_boi_nu_1.jpg', 1696552800, 1696552800),
       (20, 'quan_boi_nu_2.jpg', 2048, '/images/quan_boi_nu_2.jpg', 1696552800, 1696552800),
       (21, 'ao_khoac_the_thao_nam_1.jpg', 2048, '/images/ao_khoac_the_thao_nam_1.jpg', 1696552800, 1696552800),
       (22, 'ao_khoac_the_thao_nam_2.jpg', 2048, '/images/ao_khoac_the_thao_nam_2.jpg', 1696552800, 1696552800),
       (23, 'ao_khoac_nu_1.jpg', 2048, '/images/ao_khoac_nu_1.jpg', 1696552800, 1696552800),
       (24, 'ao_khoac_nu_2.jpg', 2048, '/images/ao_khoac_nu_2.jpg', 1696552800, 1696552800),
       (25, 'ao_thun_the_thao_nam_1.jpg', 2048, '/images/ao_thun_the_thao_nam_1.jpg', 1696552800, 1696552800),
       (26, 'ao_thun_the_thao_nam_2.jpg', 2048, '/images/ao_thun_the_thao_nam_2.jpg', 1696552800, 1696552800),
       (27, 'ao_hoodie_nu_1.jpg', 2048, '/images/ao_hoodie_nu_1.jpg', 1696552800, 1696552800),
       (28, 'ao_hoodie_nu_2.jpg', 2048, '/images/ao_hoodie_nu_2.jpg', 1696552800, 1696552800),
       (29, 'ao_polo_the_thao_1.jpg', 2048, '/images/ao_polo_the_thao_1.jpg', 1696552800, 1696552800),
       (30, 'ao_polo_the_thao_2.jpg', 2048, '/images/ao_polo_the_thao_2.jpg', 1696552800, 1696552800),
       (31, 'gay_leo_nui_co_ban_1.jpg', 2048, '/images/gay_leo_nui_co_ban_1.jpg', 1696552800, 1696552800),
       (32, 'gay_leo_nui_co_ban_2.jpg', 2048, '/images/gay_leo_nui_co_ban_2.jpg', 1696552800, 1696552800),
       (33, 'gay_leo_nui_chuyen_nghiep_1.jpg', 2048, '/images/gay_leo_nui_chuyen_nghiep_1.jpg', 1696552800, 1696552800),
       (34, 'gay_leo_nui_chuyen_nghiep_2.jpg', 2048, '/images/gay_leo_nui_chuyen_nghiep_2.jpg', 1696552800, 1696552800),
       (35, 'gay_trekking_1.jpg', 2048, '/images/gay_trekking_1.jpg', 1696552800, 1696552800),
       (36, 'gay_trekking_2.jpg', 2048, '/images/gay_trekking_2.jpg', 1696552800, 1696552800),
       (37, 'gay_hiking_1.jpg', 2048, '/images/gay_hiking_1.jpg', 1696552800, 1696552800),
       (38, 'gay_hiking_2.jpg', 2048, '/images/gay_hiking_2.jpg', 1696552800, 1696552800),
       (39, 'gay_leo_nui_thoi_trang_1.jpg', 2048, '/images/gay_leo_nui_thoi_trang_1.jpg', 1696552800, 1696552800),
       (40, 'gay_leo_nui_thoi_trang_2.jpg', 2048, '/images/gay_leo_nui_thoi_trang_2.jpg', 1696552800, 1696552800),
       (41, 'mu_the_thao_1.jpg', 2048, '/images/mu_the_thao_1.jpg', 1696552800, 1696552800),
       (42, 'mu_the_thao_2.jpg', 2048, '/images/mu_the_thao_2.jpg', 1696552800, 1696552800),
       (43, 'tui_deo_cheo_1.jpg', 2048, '/images/tui_deo_cheo_1.jpg', 1696552800, 1696552800),
       (44, 'tui_deo_cheo_2.jpg', 2048, '/images/tui_deo_cheo_2.jpg', 1696552800, 1696552800),
       (45, 'bao_tay_leo_nui_1.jpg', 2048, '/images/bao_tay_leo_nui_1.jpg', 1696552800, 1696552800),
       (46, 'bao_tay_leo_nui_2.jpg', 2048, '/images/bao_tay_leo_nui_2.jpg', 1696552800, 1696552800),
       (47, 'tat_the_thao_1.jpg', 2048, '/images/tat_the_thao_1.jpg', 1696552800, 1696552800),
       (48, 'tat_the_thao_2.jpg', 2048, '/images/tat_the_thao_2.jpg', 1696552800, 1696552800),
       (49, 'bang_do_the_thao_1.jpg', 2048, '/images/bang_do_the_thao_1.jpg', 1696552800, 1696552800),
       (50, 'bang_do_the_thao_2.jpg', 2048, '/images/bang_do_the_thao_2.jpg', 1696552800, 1696552800);

-- --------------------------------------------------------
--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `description`, `brand_id`, `created_at`, `updated_at`)
VALUES (1, 'Giày thể thao nam', 1000000, 'Giày thể thao nam thoáng khí', 1, 1696552800, 1696552800),
       (2, 'Giày chạy bộ nữ', 1200000, 'Giày chạy bộ êm ái', 2, 1696552800, 1696552800),
       (3, 'Giày bóng đá nam', 1500000, 'Giày bóng đá chuyên nghiệp', 3, 1696552800, 1696552800),
       (4, 'Giày leo núi', 2000000, 'Giày leo núi chắc chắn', 4, 1696552800, 1696552800),
       (5, 'Giày sneaker nữ', 900000, 'Giày sneaker thời trang', 5, 1696552800, 1696552800),
       (6, 'Quần thể thao nam', 500000, 'Quần thể thao co giãn', 1, 1696552800, 1696552800),
       (7, 'Quần chạy bộ nữ', 600000, 'Quần chạy bộ thoáng khí', 2, 1696552800, 1696552800),
       (8, 'Quần leo núi nam', 750000, 'Quần leo núi bền bỉ', 3, 1696552800, 1696552800),
       (9, 'Quần tập gym nam', 800000, 'Quần tập gym thoải mái', 4, 1696552800, 1696552800),
       (10, 'Quần bơi nữ', 400000, 'Quần bơi chống nước', 5, 1696552800, 1696552800),
       (11, 'Áo khoác thể thao nam', 1000000, 'Áo khoác nhẹ và thoáng', 1, 1696552800, 1696552800),
       (12, 'Áo khoác nữ', 1100000, 'Áo khoác thời trang', 2, 1696552800, 1696552800),
       (13, 'Áo thun thể thao nam', 600000, 'Áo thun thoáng khí', 3, 1696552800, 1696552800),
       (14, 'Áo hoodie nữ', 900000, 'Áo hoodie ấm áp', 4, 1696552800, 1696552800),
       (15, 'Áo polo thể thao', 700000, 'Áo polo thoải mái', 5, 1696552800, 1696552800),
       (16, 'Gậy leo núi cơ bản', 300000, 'Gậy leo núi nhẹ và chắc chắn', 1, 1696552800, 1696552800),
       (17, 'Gậy leo núi chuyên nghiệp', 500000, 'Gậy leo núi chất lượng cao', 2, 1696552800, 1696552800),
       (18, 'Gậy trekking', 450000, 'Gậy trekking đa năng', 3, 1696552800, 1696552800),
       (19, 'Gậy hiking', 600000, 'Gậy hiking bền bỉ', 4, 1696552800, 1696552800),
       (20, 'Gậy leo núi thời trang', 700000, 'Gậy leo núi phong cách', 5, 1696552800, 1696552800),
       (21, 'Mũ thể thao', 200000, 'Mũ thể thao chống nắng', 1, 1696552800, 1696552800),
       (22, 'Túi đeo chéo', 400000, 'Túi đeo chéo tiện lợi', 2, 1696552800, 1696552800),
       (23, 'Bao tay leo núi', 250000, 'Bao tay leo núi bền bỉ', 3, 1696552800, 1696552800),
       (24, 'Tất thể thao', 150000, 'Tất thể thao thoáng khí', 4, 1696552800, 1696552800),
       (25, 'Băng đô thể thao', 120000, 'Băng đô co giãn', 5, 1696552800, 1696552800);

-- --------------------------------------------------------
--
-- Dumping data for table `products_in_categories`
--

INSERT INTO `products_in_categories` (`product_id`, `category_id`)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 2),
       (7, 2),
       (8, 2),
       (9, 2),
       (10, 2),
       (11, 3),
       (12, 3),
       (13, 3),
       (14, 3),
       (15, 3),
       (16, 4),
       (17, 4),
       (18, 4),
       (19, 4),
       (20, 4),
       (21, 5),
       (22, 5),
       (23, 5),
       (24, 5),
       (25, 5);

-- --------------------------------------------------------
--
-- Dumping data for table `sizes`
--

INSERT INTO `sizes` (`id`, `size`)
VALUES (1, 'S'),
       (2, 'M'),
       (3, 'L'),
       (4, 'XL'),
       (5, 'XXL');

-- --------------------------------------------------------

--
-- Dumping data for table `variants`
--

INSERT INTO `variants` (`id`, `product_id`, `quantity`, `color_id`, `size_id`, `created_at`, `updated_at`)
VALUES (1, 1, 100, 1, 2, 1696552800, 1696552800),
       (2, 2, 80, 2, 3, 1696552800, 1696552800),
       (3, 3, 120, 3, 4, 1696552800, 1696552800),
       (4, 4, 60, 4, 5, 1696552800, 1696552800),
       (5, 5, 50, 5, 1, 1696552800, 1696552800),
       (6, 6, 90, 1, 2, 1696552800, 1696552800),
       (7, 7, 110, 2, 3, 1696552800, 1696552800),
       (8, 8, 70, 3, 4, 1696552800, 1696552800),
       (9, 9, 40, 4, 5, 1696552800, 1696552800),
       (10, 10, 30, 5, 1, 1696552800, 1696552800),
       (11, 11, 100, 1, 2, 1696552800, 1696552800),
       (12, 12, 80, 2, 3, 1696552800, 1696552800),
       (13, 13, 120, 3, 4, 1696552800, 1696552800),
       (14, 14, 60, 4, 5, 1696552800, 1696552800),
       (15, 15, 50, 5, 1, 1696552800, 1696552800),
       (16, 16, 90, 1, 2, 1696552800, 1696552800),
       (17, 17, 110, 2, 3, 1696552800, 1696552800),
       (18, 18, 70, 3, 4, 1696552800, 1696552800),
       (19, 19, 40, 4, 5, 1696552800, 1696552800),
       (20, 20, 30, 5, 1, 1696552800, 1696552800),
       (21, 21, 100, 1, 2, 1696552800, 1696552800),
       (22, 22, 80, 2, 3, 1696552800, 1696552800),
       (23, 23, 120, 3, 4, 1696552800, 1696552800),
       (24, 24, 60, 4, 5, 1696552800, 1696552800),
       (25, 25, 50, 5, 1, 1696552800, 1696552800);

-- --------------------------------------------------------

--
-- Dumping data for table `variant_file`
--

INSERT INTO `variant_file` (`variant_id`, `file_id`)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8),
       (5, 9),
       (5, 10),
       (6, 11),
       (6, 12),
       (7, 13),
       (7, 14),
       (8, 15),
       (8, 16),
       (9, 17),
       (9, 18),
       (10, 19),
       (10, 20),
       (11, 21),
       (11, 22),
       (12, 23),
       (12, 24),
       (13, 25),
       (13, 26),
       (14, 27),
       (14, 28),
       (15, 29),
       (15, 30),
       (16, 31),
       (16, 32),
       (17, 33),
       (17, 34),
       (18, 35),
       (18, 36),
       (19, 37),
       (19, 38),
       (20, 39),
       (20, 40),
       (21, 41),
       (21, 42),
       (22, 43),
       (22, 44),
       (23, 45),
       (23, 46),
       (24, 47),
       (24, 48),
       (25, 49),
       (25, 50);