package org.mf.controller;

class CaricaController {

//    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        respond Carica.list(params), model:[caricaInstanceCount: Carica.count()]
//    }
//
//    def show(Carica caricaInstance) {
//        respond caricaInstance
//    }
//
//    def create() {
//        respond new Carica(params)
//    }
//
//    @Transactional
//    def save(Carica caricaInstance) {
//        if (caricaInstance == null) {
//            notFound()
//            return
//        }
//
//        if (caricaInstance.hasErrors()) {
//            respond caricaInstance.errors, view:'create'
//            return
//        }
//
//        caricaInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'carica.label', default: 'Carica'), caricaInstance.id])
//                redirect caricaInstance
//            }
//            '*' { respond caricaInstance, [status: CREATED] }
//        }
//    }
//
//    def edit(Carica caricaInstance) {
//        respond caricaInstance
//    }
//
//    @Transactional
//    def update(Carica caricaInstance) {
//        if (caricaInstance == null) {
//            notFound()
//            return
//        }
//
//        if (caricaInstance.hasErrors()) {
//            respond caricaInstance.errors, view:'edit'
//            return
//        }
//
//        caricaInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.updated.message', args: [message(code: 'Carica.label', default: 'Carica'), caricaInstance.id])
//                redirect caricaInstance
//            }
//            '*'{ respond caricaInstance, [status: OK] }
//        }
//    }
//
//    @Transactional
//    def delete(Carica caricaInstance) {
//
//        if (caricaInstance == null) {
//            notFound()
//            return
//        }
//
//        caricaInstance.delete flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Carica.label', default: 'Carica'), caricaInstance.id])
//                redirect action:"index", method:"GET"
//            }
//            '*'{ render status: NO_CONTENT }
//        }
//    }
//
//    protected void notFound() {
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.not.found.message', args: [message(code: 'carica.label', default: 'Carica'), params.id])
//                redirect action: "index", method: "GET"
//            }
//            '*'{ render status: NOT_FOUND }
//        }
//    }
}
