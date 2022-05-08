1.Package Entity có product là một thực thể
2.Package repository có interface productRepository
kế thừa JpaRepository để query dữ liệu
3.Package controller có :
    -class HomeController trả về index.jsp
    -class Product:
        + @GetMapping("/products") trả về dữ liệu và đưa lên web danh sách sản phẩm
        + @GetMapping("/update") trả về trang update.jsp
        + @PostMapping("/update") lấy dữ liêu từ người dùng gửi lên, kiểm tra nếu đúng thì sẽ lưu vào database, sai thì ghi lỗi trên trang update
        + @GetMapping("/edit") kiểm tra sản phẩm phẩm có trong database không, nếu có trả về trang edit.jsp, không thì báo lỗi 
        + @PostMapping("/edit") kiểm tra nếu sản phẩm không có thì trả về lỗi, có thì kiểm tra price có thỏa mãn điều kiện không, 
	không thì hiện lỗi và cần nhập lại, có thì update dữ liệu lên database
        + @GetMapping("/confirmdelete") kiểm tra sản phẩm có tồn tại không, không thì trả về lỗi không tìm thấy sản phẩm, có thì trả về trang delete
        + @GetMapping("/delete") kiểm tra sản phẩm có tồn tại không, không thì trả về lỗi không tìm thấy sản phẩm, có thì xóa dữ liệu khỏi database

