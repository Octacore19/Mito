package com.octacoresoftwares.firebase.implementations

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.octacoresoftwares.firebase.contracts.IFirebaseFireStore
import javax.inject.Inject

class FirebaseFireStoreImpl @Inject constructor(private val db: FirebaseFirestore):
    IFirebaseFireStore {

    override fun <D> addDataToCollection(collectionPath: String, data: D) =
        data?.let {
            db.collection(collectionPath)
                .add(it)
        }

    override fun <D> setDataToDocumentInCollection(collectionPath: String, documentId: String, data: D) =
        data?.let {
            db.collection(collectionPath)
                .document(documentId)
                .set(it)
        }

    override fun <D> setDataToDocumentWithMerge(collectionPath: String, documentId: String, data: D) =
        data?.let {
            db.collection(collectionPath)
                .document(documentId)
                .set(it, SetOptions.merge())
        }

    override fun <F> updatingFieldInDocument(collectionPath: String, documentId: String, fieldRef: String, data: F) =
        data?.let {
            val ref = db.collection(collectionPath)
                .document(documentId)
            ref.update(fieldRef, it)
        }

    override fun deleteDocumentFromCollection(collectionPath: String, documentId: String) =
        db.collection(collectionPath)
            .document(documentId)
            .delete()

    override fun deleteFieldFromDocumentInCollection(collectionPath: String, documentId: String, fieldRef: String) =
        db.collection(collectionPath).document(documentId).let {
            val update = hashMapOf<String, Any>(
                fieldRef to FieldValue.delete()
            )
            it.update(update)
        }


}