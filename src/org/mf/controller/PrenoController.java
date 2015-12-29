package org.mf.controller;

class PrenoController {

//    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        respond Preno.list(params), model:[prenoInstanceCount: Preno.count()]
//    }
//
//    def show(Preno prenoInstance) {
//        respond prenoInstance
//    }
//
//    def create() {
//        respond new Preno(params)
//    }
//
//    @Transactional
//    def save(Preno prenoInstance) {
//        if (prenoInstance == null) {
//            notFound()
//            return
//        }
//
//        if (prenoInstance.hasErrors()) {
//            respond prenoInstance.errors, view:'create'
//            return
//        }
//
//        prenoInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'preno.label', default: 'Preno'), prenoInstance.id])
//                redirect prenoInstance
//            }
//            '*' { respond prenoInstance, [status: CREATED] }
//        }
//    }
//
//    def edit(Preno prenoInstance) {
//        respond prenoInstance
//    }
//
//    @Transactional
//    def update(Preno prenoInstance) {
//        if (prenoInstance == null) {
//            notFound()
//            return
//        }
//
//        if (prenoInstance.hasErrors()) {
//            respond prenoInstance.errors, view:'edit'
//            return
//        }
//
//        prenoInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.updated.message', args: [message(code: 'Preno.label', default: 'Preno'), prenoInstance.id])
//                redirect prenoInstance
//            }
//            '*'{ respond prenoInstance, [status: OK] }
//        }
//    }
//
//    @Transactional
//    def delete(Preno prenoInstance) {
//
//        if (prenoInstance == null) {
//            notFound()
//            return
//        }
//
//        prenoInstance.delete flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Preno.label', default: 'Preno'), prenoInstance.id])
//                redirect action:"index", method:"GET"
//            }
//            '*'{ render status: NO_CONTENT }
//        }
//    }
//
//    protected void notFound() {
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.not.found.message', args: [message(code: 'preno.label', default: 'Preno'), params.id])
//                redirect action: "index", method: "GET"
//            }
//            '*'{ render status: NOT_FOUND }
//        }
//    }
}
