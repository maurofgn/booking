package org.mf.controller;

class CampoController {

//   def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        respond Campo.list(params), model:[campoInstanceCount: Campo.count()]
//    }
//
//    def show(Campo campoInstance) {
//        respond campoInstance
//    }
//
//    def create() {
//        respond new Campo(params)
//    }
//
//    @Transactional
//    def save(Campo campoInstance) {
//        if (campoInstance == null) {
//            notFound()
//            return
//        }
//
//        if (campoInstance.hasErrors()) {
//            respond campoInstance.errors, view:'create'
//            return
//        }
//
//        campoInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'campo.label', default: 'Campo'), campoInstance.id])
//                redirect campoInstance
//            }
//            '*' { respond campoInstance, [status: CREATED] }
//        }
//    }
//
//    def edit(Campo campoInstance) {
//        respond campoInstance
//    }
//
//    @Transactional
//    def update(Campo campoInstance) {
//        if (campoInstance == null) {
//            notFound()
//            return
//        }
//
//        if (campoInstance.hasErrors()) {
//            respond campoInstance.errors, view:'edit'
//            return
//        }
//
//        campoInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.updated.message', args: [message(code: 'Campo.label', default: 'Campo'), campoInstance.id])
//                redirect campoInstance
//            }
//            '*'{ respond campoInstance, [status: OK] }
//        }
//    }
//
//    @Transactional
//    def delete(Campo campoInstance) {
//
//        if (campoInstance == null) {
//            notFound()
//            return
//        }
//
//        campoInstance.delete flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Campo.label', default: 'Campo'), campoInstance.id])
//                redirect action:"index", method:"GET"
//            }
//            '*'{ render status: NO_CONTENT }
//        }
//    }
//
//    protected void notFound() {
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.not.found.message', args: [message(code: 'campo.label', default: 'Campo'), params.id])
//                redirect action: "index", method: "GET"
//            }
//            '*'{ render status: NOT_FOUND }
//        }
//    }
}
