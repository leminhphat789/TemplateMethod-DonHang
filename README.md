# Xử lý đơn hàng bằng Template Method

Chương trình Java xử lý đơn hàng theo hai hình thức: giao tận nơi hoặc nhận tại cửa hàng. Cả hai dùng chung cách tính tiền sản phẩm nhưng có quy định riêng về thông tin nhận hàng và mức phí.

## Cách áp dụng Template Method

Lớp `OrderProcessor` định nghĩa phương thức `processOrder()` để kiểm tra đơn, tính tiền sản phẩm, kiểm tra thông tin nhận hàng, tính phí và in xác nhận. Phương thức này được khai báo `final` để hai lớp con thực hiện các bước theo cùng thứ tự.

- `HomeDeliveryProcessor` kiểm tra địa chỉ giao, tính phí 20.000 đồng và in địa chỉ nhận hàng.
- `StorePickupProcessor` kiểm tra mã cửa hàng, tính phí 0 đồng và hướng dẫn khách đến quầy nhận hàng.
