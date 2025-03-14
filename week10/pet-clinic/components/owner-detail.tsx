"use client"

import { useState, useEffect } from "react"
import { Edit, Phone, MapPin } from "lucide-react"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL || "http://localhost:8080";

interface Pet {
  id: number
  name: string
  birthDate: string
  type: string
}

interface Owner {
  id: number

  firstName: string
  lastName: string
  address: string
  city: string
  telephone: string
  pets: Pet[]
}

interface OwnerDetailProps {
  ownerId: number
  onEdit: () => void
}

export default function OwnerDetail({ ownerId, onEdit }: OwnerDetailProps) {
  const [owner, setOwner] = useState<Owner | null>(null)
  const [isLoading, setIsLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    const fetchOwnerDetail = async () => {
      setIsLoading(true)
      setError(null)

      try {
        const response = await fetch(`http://localhost:8080/owners/${ownerId}`)

        if (!response.ok) {
          throw new Error("소유자 정보를 불러오는 중 오류가 발생했습니다")
        }

        const data = await response.json()
        setOwner(data)
      } catch (err) {
        setError(err instanceof Error ? err.message : "소유자 정보를 불러오는 중 오류가 발생했습니다")
      } finally {
        setIsLoading(false)
      }
    }

    fetchOwnerDetail()
  }, [ownerId])

  if (isLoading) {
    return <div className="text-center py-10">정보를 불러오는 중...</div>
  }

  if (error) {
    return <div className="p-4 text-center text-red-500 bg-red-50 rounded-xl">{error}</div>
  }

  if (!owner) {
    return <div className="text-center py-10">소유자 정보를 찾을 수 없습니다</div>
  }

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader className="pb-2">
          <div className="flex justify-between items-center">
            <CardTitle className="text-xl font-bold text-[#333D4B]">
              {owner.lastName} {owner.firstName}
            </CardTitle>
            <Button variant="outline" size="sm" onClick={onEdit} className="rounded-full border-gray-200">
              <Edit className="h-4 w-4 mr-1" />
              수정
            </Button>
          </div>
        </CardHeader>
        <CardContent className="space-y-3">
          <div className="flex items-center text-gray-600">
            <MapPin className="h-4 w-4 mr-2 text-gray-400" />
            <span>
              {owner.address}, {owner.city}
            </span>
          </div>
          <div className="flex items-center text-gray-600">
            <Phone className="h-4 w-4 mr-2 text-gray-400" />
            <span>{owner.telephone}</span>
          </div>
        </CardContent>
      </Card>

      <div className="space-y-3">
        <div className="flex justify-between items-center">
          <h2 className="text-lg font-medium text-[#333D4B]">반려동물 목록</h2>
        </div>

        {owner.pets && owner.pets.length > 0 ? (
          <div className="space-y-3">
            {owner.pets.map((pet) => (
              <Card key={pet.id}>
                <CardContent className="p-4">
                  <div className="flex justify-between items-center">
                    <div>
                      <h3 className="font-medium text-[#333D4B]">{pet.name}</h3>
                      <p className="text-sm text-gray-500">
                        {pet.type} • 생일: {new Date(pet.birthDate).toLocaleDateString()}
                      </p>
                    </div>
                  </div>
                </CardContent>
              </Card>
            ))}
          </div>
        ) : (
          <div className="text-center py-6 bg-gray-50 rounded-xl text-gray-500">등록된 반려동물이 없습니다</div>
        )}
      </div>
    </div>
  )
}

