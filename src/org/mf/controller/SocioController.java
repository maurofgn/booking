package org.mf.controller;

class SocioController {

//    public void index(Integer max) {
//        params.max = Math.min(max != null ? max : 10, 100)
//        respond Socio.list(params), model:[socioInstanceCount: Socio.count()]
//    }
//
//    def show(Socio socioInstance) {
//        respond socioInstance
//    }
//
//    def create() {
//        respond new Socio(params)
//    }
//
//    @Transactional
//    def save(Socio socioInstance) {
//        if (socioInstance == null) {
//            notFound()
//            return
//        }
//
//        if (socioInstance.hasErrors()) {
//            respond socioInstance.errors, view:'create'
//            return
//        }
//
//        socioInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'socio.label', default: 'Socio'), socioInstance.id])
//                redirect socioInstance
//            }
//            '*' { respond socioInstance, [status: CREATED] }
//        }
//    }
//
//    def edit(Socio socioInstance) {
//        respond socioInstance
//    }
//
//    @Transactional
//    def update(Socio socioInstance) {
//        if (socioInstance == null) {
//            notFound()
//            return
//        }
//
//        if (socioInstance.hasErrors()) {
//            respond socioInstance.errors, view:'edit'
//            return
//        }
//
//        socioInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.updated.message', args: [message(code: 'Socio.label', default: 'Socio'), socioInstance.id])
//                redirect socioInstance
//            }
//            '*'{ respond socioInstance, [status: OK] }
//        }
//    }
//
//    @Transactional
//    def delete(Socio socioInstance) {
//
//        if (socioInstance == null) {
//            notFound()
//            return
//        }
//
//        socioInstance.delete flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Socio.label', default: 'Socio'), socioInstance.id])
//                redirect action:"index", method:"GET"
//            }
//            '*'{ render status: NO_CONTENT }
//        }
//    }
//
//    protected void notFound() {
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.not.found.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
//                redirect action: "index", method: "GET"
//            }
//            '*'{ render status: NOT_FOUND }
//        }
//    }
}
