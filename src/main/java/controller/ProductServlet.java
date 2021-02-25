package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    ProductService productService = new ProductService();
    List<Category> categoryList = categoryService.findAll();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        if (action==null){
            action = "";

        }
        switch (action){
            case "showAll":
                showAllProduct(request,response);
                break;
            case "createProduct":
                showCreateNew(request,response);
                break;
            case "updateProduct":
                showUpdateProduct(request,response);
            case "deleteProduct":
                showDeleteProduct(request,response);
                break;
            case "findByName":
                showFindByName(request,response);
                break;
        }
    }

    private void showFindByName(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void showCreateNew(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList",productList);
        request.setAttribute("productCategory", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showAll.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
