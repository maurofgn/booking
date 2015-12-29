package org.mf.controller;

class SocietaController {

//    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        respond Societa.list(params), model:[societaInstanceCount: Societa.count()]
//    }
//
//    def show(Societa societaInstance) {
//        respond societaInstance
//    }
//
//    def create() {
//        respond new Societa(params)
//    }
//
//    @Transactional
//    def save(Societa societaInstance) {
//        if (societaInstance == null) {
//            notFound()
//            return
//        }
//
//        if (societaInstance.hasErrors()) {
//            respond societaInstance.errors, view:'create'
//            return
//        }
//
//        societaInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'societa.label', default: 'Societa'), societaInstance.id])
//                redirect societaInstance
//            }
//            '*' { respond societaInstance, [status: CREATED] }
//        }
//    }
//
//    def edit(Societa societaInstance) {
//        respond societaInstance
//    }
//
//    @Transactional
//    def update(Societa societaInstance) {
//        if (societaInstance == null) {
//            notFound()
//            return
//        }
//
//        if (societaInstance.hasErrors()) {
//            respond societaInstance.errors, view:'edit'
//            return
//        }
//
//        societaInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.updated.message', args: [message(code: 'Societa.label', default: 'Societa'), societaInstance.id])
//                redirect societaInstance
//            }
//            '*'{ respond societaInstance, [status: OK] }
//        }
//    }
//
//    @Transactional
//    def delete(Societa societaInstance) {
//
//        if (societaInstance == null) {
//            notFound()
//            return
//        }
//
//        societaInstance.delete flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Societa.label', default: 'Societa'), societaInstance.id])
//                redirect action:"index", method:"GET"
//            }
//            '*'{ render status: NO_CONTENT }
//        }
//    }
//
//    protected void notFound() {
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.not.found.message', args: [message(code: 'societa.label', default: 'Societa'), params.id])
//                redirect action: "index", method: "GET"
//            }
//            '*'{ render status: NOT_FOUND }
//        }
//    }
}
