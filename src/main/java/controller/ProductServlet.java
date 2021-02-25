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

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    ProductService productService = new ProductService();
    List<Category> categoryList = categoryService.findAll();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "showAll":
                showAllProduct(request, response);
                break;
            case "createProduct":
                showCreateNew(request, response);
                break;
            case "updateProduct":
                showUpdateProduct(request, response);
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                break;
            case "searchByName":
                showFindByName(request, response);
                break;
        }
    }

    private void showFindByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Product product = productService.findByName(name);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        request.setAttribute("productList", productList);
        request.setAttribute("productCategory", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showAll.jsp");
        requestDispatcher.forward(request, response);


    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
            response.sendRedirect("/");


    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void showCreateNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("createForm.jsp");
        requestDispatcher.forward(request,response);

    }


    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        request.setAttribute("productCategory", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showAll.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "createProduct":
                createNew(request, response);
                break;
            case "updateProduct":
                updateProduct(request, response);
        }

    }

    private void createNew(HttpServletRequest request, HttpServletResponse response) {
        int id = 0;
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int number = Integer.parseInt(request.getParameter("number"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_category = Integer.parseInt(request.getParameter("id_category"));
        Product product = new Product(id, name, price, number, color, description, id_category);
        productService.create(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int number = Integer.parseInt(request.getParameter("number"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_category = Integer.parseInt(request.getParameter("id_category"));
        Product product = new Product(id, name, price, number, color, description, id_category);
        productService.update(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
