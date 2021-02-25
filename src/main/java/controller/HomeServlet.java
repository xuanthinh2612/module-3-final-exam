package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/")
public class HomeServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    List<Category> productCategory = categoryService.findAll();
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "":
                showAllProduct(request,response);
                break;
            case "searchByName":
                findResult(request,response);
                break;

        }
    }

    private void findResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Product product = productService.findByName(name);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        request.setAttribute("productList", productList);
        request.setAttribute("productCategory", productCategory);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showAll.jsp");
        requestDispatcher.forward(request, response);


    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList",productList);
        request.setAttribute("productCategory",productCategory);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showAll.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
