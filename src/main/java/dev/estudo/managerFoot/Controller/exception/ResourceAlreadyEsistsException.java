package dev.estudo.managerFoot.Controller.exception;

public class ResourceAlreadyEsistsException extends RuntimeException{
    public ResourceAlreadyEsistsException(String message){
        super(message);
    }
}
