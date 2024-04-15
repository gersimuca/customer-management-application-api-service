//package frontend.model;
//
//import backend.model.Client;
//import backend.repository.ClientRepository;
//import frontend.controller.CreateClientController;
//import frontend.view.CreateClientView;
//import frontend.view.IndexView;
//import frontend.view.responses.EmailExistError;
//
//import javax.persistence.RollbackException;
//import javax.swing.*;
//
//public class CreateClientModel implements CreateClientController {
//    private final ClientRepository clientRepository = new ClientRepository();
//
//    @Override
//    public void createClient(CreateClientView createClientView, JButton button) {
//        button.addActionListener(e -> {
//            Client client = new Client();
//            client.setFirstName(createClientView.getFirstName().getText());
//            client.setLastName(createClientView.getLastName().getText());
//            client.setEmail(createClientView.getEmail().getText());
//            client.setPassword(createClientView.getPassword().getText());
//
//            try{
//                clientRepository.createClient(client);
//            } catch (RollbackException re){
//                re.printStackTrace();
//                new EmailExistError();
//                return;
//            }
//            createClientView.dispose();
//            new IndexView();
//        });
//    }
//
//    @Override
//    public void backToMain(JFrame frame, JButton button) {
//        button.addActionListener(e -> {
//            frame.dispose();
//            new IndexView();
//        });
//    }
//}
