package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.Controller;
import exceptions.ToyException;
import model.expressions.ArithmeticExpr;
import model.expressions.LogicExpr;
import model.expressions.ValueExpr;
import model.expressions.VariableExpr;
import model.statements.AssignStmt;
import model.statements.CompStmt;
import model.statements.EmptyStmt;
import model.statements.IStmt;
import model.statements.IfStatement;
import model.statements.PrintStmt;
import model.statements.VarDeclIStmt;
import model.types.BoolType;
import model.types.IntType;
import model.values.BooleanValue;
import model.values.IntValue;
import repo.IRepository;
import repo.Repository;

public class View {
        Controller controller;

        public View() {
                IRepository repo = new Repository();
                this.controller = new Controller(repo);

        }

        IStmt ex = new CompStmt(new VarDeclIStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("v", new ValueExpr(new IntValue(2))),
                                        new PrintStmt(new VariableExpr("v"))));

        IStmt ex4 = new CompStmt(new VarDeclIStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("v", new ValueExpr(new IntValue(2))),
                                        new PrintStmt(new LogicExpr(new ValueExpr(new BooleanValue(true)),
                                                        new ValueExpr(new BooleanValue(false)), '|'))));

        IStmt ex2 = new CompStmt(new VarDeclIStmt("a", new IntType()), new CompStmt(
                        new VarDeclIStmt("b", new IntType()),
                        new CompStmt(new AssignStmt("a",
                                        new ArithmeticExpr(new ValueExpr(new IntValue(2)),
                                                        new ArithmeticExpr(new ValueExpr(new IntValue(3)),
                                                                        new ValueExpr(new IntValue(5)), '*'),
                                                        '+')),
                                        new CompStmt(new AssignStmt("b",
                                                        new ArithmeticExpr(new VariableExpr("a"),
                                                                        new ValueExpr(new IntValue(1)), '+')),
                                                        new CompStmt(new PrintStmt(new VariableExpr("b")),
                                                                        new VarDeclIStmt("b", new IntType()))))));

        IStmt ex3 = new CompStmt(new VarDeclIStmt("a", new BoolType()),
                        new CompStmt(new VarDeclIStmt("v", new IntType()),
                                        new CompStmt(new AssignStmt("a", new ValueExpr(new BooleanValue(true))),
                                                        new CompStmt(
                                                                        new IfStatement(new AssignStmt("v",
                                                                                        new ValueExpr(new IntValue(2))),
                                                                                        new AssignStmt("v",
                                                                                                        new ValueExpr(new IntValue(
                                                                                                                        3))),
                                                                                        new VariableExpr("a")),
                                                                        new PrintStmt(new VariableExpr("v"))))));

        public void menu() {
                System.out.println("\n0. Stop execution");
                System.out.println("9. Change flag");
                System.out.println("Set example");

                System.out.println("\t1. Example 1");
                System.out.println("\t2. Example 2");
                System.out.println("\t3. Example 3");
                System.out.println("\t4. Example 4");
                System.out.println("5. Run example");
                //

        }

        public void run() {
                while (true) {
                        try {
                                this.menu();
                                System.out.print("Enter comand: ");
                                Scanner scan = new Scanner(System.in);

                                int option = scan.nextInt();

                                switch (option) {
                                        case 1:
                                                this.controller.newProgram(ex);
                                                break;
                                        case 2:
                                                this.controller.newProgram(ex2);// ex2
                                                break;
                                        case 3:
                                                this.controller.newProgram(ex3);
                                                break;
                                        case 4:
                                                this.controller.newProgram(ex4);
                                                break;
                                        case 5:
                                                runExample();
                                                break;
                                        case 9:
                                                changeDisplayFlag();
                                                break;
                                        case 0:
                                                return;

                                        default:
                                                System.out.println("Not an input");
                                                break;
                                }

                        } catch (InputMismatchException e) {
                                System.out.println("Exception is " + e.getMessage());
                        }

                }
        }

        private void changeDisplayFlag() {
                this.controller.changeDisplayFlag();
                System.out.println("Flag is changed");
        }

        public void runExample() {

                try {
                        this.controller.allStep();
                } catch (ToyException e) {
                        System.out.println(e.getMessage());
                }

        }

}
